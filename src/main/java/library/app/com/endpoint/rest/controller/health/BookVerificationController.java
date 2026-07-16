package library.app.com.endpoint.rest.controller.health;

import library.app.com.entity.BookVerificationResult;
import library.app.com.service.external.BookVerificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookVerificationController {

  private final BookVerificationService service;

  @GetMapping("/verify/{isbn}")
  public BookVerificationResult verifyByIsbn(@PathVariable String isbn) {
    return service.verifyByIsbn(isbn);
  }

  /**
   * Cherche un livre par texte libre sur OpenLibrary ou Google Books. GET
   * /books/search?q=Les+Misérables
   *
   * <p>Exemples : GET /books/search?q=Les+Miserables GET /books/search?q=Victor+Hugo GET
   * /books/search?q=978-2070409228
   */
  @GetMapping("/search")
  public BookVerificationResult search(@RequestParam String q) {
    return service.search(q);
  }
}
