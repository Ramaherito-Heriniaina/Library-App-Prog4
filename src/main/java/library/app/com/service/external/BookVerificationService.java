package library.app.com.service.external;

import library.app.com.entity.BookVerificationResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookVerificationService {

  private final OpenLibraryClient openLibraryClient;
  private final GoogleBooksClient googleBooksClient;

  /**
   * Vérifie si un livre existe via son ISBN. 1. Cherche d'abord sur OpenLibrary 2. Si non trouvé,
   * cherche sur Google Books (fallback) 3. Si non trouvé nulle part, retourne found: false
   */
  public BookVerificationResult verifyByIsbn(String isbn) {
    log.info("Verifying book ISBN: {}", isbn);

    // 1. OpenLibrary
    var openLibResult = openLibraryClient.findByIsbn(isbn);
    if (openLibResult.isPresent()) {
      log.info("Found on OpenLibrary: {}", isbn);
      return openLibResult.get();
    }

    // 2. Google Books (fallback)
    log.info("Not found on OpenLibrary, trying Google Books for ISBN: {}", isbn);
    var googleResult = googleBooksClient.findByIsbn(isbn);
    if (googleResult.isPresent()) {
      log.info("Found on Google Books: {}", isbn);
      return googleResult.get();
    }

    // 3. Non trouvé
    log.info("Book not found anywhere for ISBN: {}", isbn);
    return BookVerificationResult.builder().found(false).isbn(isbn).build();
  }

  /**
   * Cherche un livre par texte libre (titre, auteur...). Même logique : OpenLibrary d'abord, Google
   * Books en fallback.
   */
  public BookVerificationResult search(String query) {
    log.info("Searching book: {}", query);

    // 1. OpenLibrary
    var openLibResult = openLibraryClient.search(query);
    if (openLibResult.isPresent()) {
      log.info("Found on OpenLibrary: {}", query);
      return openLibResult.get();
    }

    // 2. Google Books (fallback)
    log.info("Not found on OpenLibrary, trying Google Books for: {}", query);
    var googleResult = googleBooksClient.search(query);
    if (googleResult.isPresent()) {
      log.info("Found on Google Books: {}", query);
      return googleResult.get();
    }

    // 3. Non trouvé
    return BookVerificationResult.builder().found(false).build();
  }
}
