package library.app.com.service.external;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Optional;
import library.app.com.entity.BookVerificationResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
@RequiredArgsConstructor
public class OpenLibraryClient {

  private static final String BASE_URL = "https://openlibrary.org";
  private final RestTemplate restTemplate;
  private final ObjectMapper objectMapper;

  public Optional<BookVerificationResult> findByIsbn(String isbn) {
    try {
      String url = BASE_URL + "/api/books?bibkeys=ISBN:" + isbn + "&format=json&jscmd=data";
      String response = restTemplate.getForObject(url, String.class);

      if (response == null || response.equals("{}")) {
        return Optional.empty();
      }

      JsonNode root = objectMapper.readTree(response);
      JsonNode bookNode = root.get("ISBN:" + isbn);

      if (bookNode == null) {
        return Optional.empty();
      }

      BookVerificationResult result =
          BookVerificationResult.builder()
              .found(true)
              .source("OpenLibrary")
              .isbn(isbn)
              .title(getText(bookNode, "title"))
              .author(getFirstAuthor(bookNode))
              .publishedDate(getText(bookNode, "publish_date"))
              .publisher(getFirstPublisher(bookNode))
              .pageCount(getInt(bookNode, "number_of_pages"))
              .coverUrl(getCoverUrl(bookNode))
              .build();

      return Optional.of(result);

    } catch (Exception e) {
      log.error("OpenLibrary error for ISBN {}: {}", isbn, e.getMessage());
      return Optional.empty();
    }
  }

  public Optional<BookVerificationResult> search(String query) {
    try {
      String url = BASE_URL + "/search.json?q=" + query.replace(" ", "+") + "&limit=1";
      String response = restTemplate.getForObject(url, String.class);

      if (response == null) return Optional.empty();

      JsonNode root = objectMapper.readTree(response);
      JsonNode docs = root.get("docs");

      if (docs == null || !docs.isArray() || docs.isEmpty()) {
        return Optional.empty();
      }

      JsonNode book = docs.get(0);

      BookVerificationResult result =
          BookVerificationResult.builder()
              .found(true)
              .source("OpenLibrary")
              .isbn(getFirstIsbn(book))
              .title(getText(book, "title"))
              .author(getFirstAuthorFromSearch(book))
              .publishedDate(getTextFromInt(book, "first_publish_year"))
              .publisher(getFirstPublisherFromSearch(book))
              .pageCount(getInt(book, "number_of_pages_median"))
              .build();

      return Optional.of(result);

    } catch (Exception e) {
      log.error("OpenLibrary search error for '{}': {}", query, e.getMessage());
      return Optional.empty();
    }
  }

  // ===== Helpers =====

  private String getText(JsonNode node, String field) {
    JsonNode n = node.get(field);
    return n != null && !n.isNull() ? n.asText() : null;
  }

  private String getTextFromInt(JsonNode node, String field) {
    JsonNode n = node.get(field);
    return n != null && !n.isNull() ? String.valueOf(n.asInt()) : null;
  }

  private Integer getInt(JsonNode node, String field) {
    JsonNode n = node.get(field);
    return n != null && !n.isNull() ? n.asInt() : null;
  }

  private String getFirstAuthor(JsonNode bookNode) {
    JsonNode authors = bookNode.get("authors");
    if (authors != null && authors.isArray() && !authors.isEmpty()) {
      JsonNode author = authors.get(0);
      return getText(author, "name");
    }
    return null;
  }

  private String getFirstAuthorFromSearch(JsonNode book) {
    JsonNode authors = book.get("author_name");
    if (authors != null && authors.isArray() && !authors.isEmpty()) {
      return authors.get(0).asText();
    }
    return null;
  }

  private String getFirstPublisher(JsonNode bookNode) {
    JsonNode publishers = bookNode.get("publishers");
    if (publishers != null && publishers.isArray() && !publishers.isEmpty()) {
      return getText(publishers.get(0), "name");
    }
    return null;
  }

  private String getFirstPublisherFromSearch(JsonNode book) {
    JsonNode publishers = book.get("publisher");
    if (publishers != null && publishers.isArray() && !publishers.isEmpty()) {
      return publishers.get(0).asText();
    }
    return null;
  }

  private String getFirstIsbn(JsonNode book) {
    JsonNode isbns = book.get("isbn");
    if (isbns != null && isbns.isArray() && !isbns.isEmpty()) {
      return isbns.get(0).asText();
    }
    return null;
  }

  private String getCoverUrl(JsonNode bookNode) {
    JsonNode cover = bookNode.get("cover");
    if (cover != null) {
      JsonNode large = cover.get("large");
      if (large != null) return large.asText();
      JsonNode medium = cover.get("medium");
      if (medium != null) return medium.asText();
    }
    return null;
  }
}
