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
public class GoogleBooksClient {

  private static final String BASE_URL = "https://www.googleapis.com/books/v1/volumes";
  private final RestTemplate restTemplate;
  private final ObjectMapper objectMapper;

  /**
   * Cherche un livre par ISBN sur Google Books. URL :
   * https://www.googleapis.com/books/v1/volumes?q=isbn:{isbn}
   */
  public Optional<BookVerificationResult> findByIsbn(String isbn) {
    return search("isbn:" + isbn, isbn);
  }

  /**
   * Cherche un livre par texte libre sur Google Books. URL :
   * https://www.googleapis.com/books/v1/volumes?q={query}
   */
  public Optional<BookVerificationResult> search(String query) {
    return search(query, null);
  }

  private Optional<BookVerificationResult> search(String query, String originalIsbn) {
    try {
      String url = BASE_URL + "?q=" + query.replace(" ", "+") + "&maxResults=1";
      String response = restTemplate.getForObject(url, String.class);

      if (response == null) return Optional.empty();

      JsonNode root = objectMapper.readTree(response);
      int totalItems = root.path("totalItems").asInt(0);

      if (totalItems == 0) return Optional.empty();

      JsonNode item = root.path("items").get(0);
      JsonNode info = item.path("volumeInfo");

      String isbn = originalIsbn != null ? originalIsbn : extractIsbn(info);

      BookVerificationResult result =
          BookVerificationResult.builder()
              .found(true)
              .source("GoogleBooks")
              .isbn(isbn)
              .title(info.path("title").asText(null))
              .author(getFirstAuthor(info))
              .publishedDate(info.path("publishedDate").asText(null))
              .description(info.path("description").asText(null))
              .publisher(info.path("publisher").asText(null))
              .pageCount(info.has("pageCount") ? info.path("pageCount").asInt() : null)
              .coverUrl(getCoverUrl(info))
              .build();

      return Optional.of(result);

    } catch (Exception e) {
      log.error("GoogleBooks error for '{}': {}", query, e.getMessage());
      return Optional.empty();
    }
  }

  // ===== Helpers =====

  private String getFirstAuthor(JsonNode info) {
    JsonNode authors = info.get("authors");
    if (authors != null && authors.isArray() && !authors.isEmpty()) {
      return authors.get(0).asText();
    }
    return null;
  }

  private String extractIsbn(JsonNode info) {
    JsonNode identifiers = info.get("industryIdentifiers");
    if (identifiers != null && identifiers.isArray()) {
      for (JsonNode id : identifiers) {
        String type = id.path("type").asText("");
        if (type.equals("ISBN_13") || type.equals("ISBN_10")) {
          return id.path("identifier").asText(null);
        }
      }
    }
    return null;
  }

  private String getCoverUrl(JsonNode info) {
    JsonNode images = info.get("imageLinks");
    if (images != null) {
      if (images.has("thumbnail")) return images.path("thumbnail").asText();
      if (images.has("smallThumbnail")) return images.path("smallThumbnail").asText();
    }
    return null;
  }
}
