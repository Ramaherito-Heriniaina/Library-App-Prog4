package library.app.com.endpoint.rest.controller.health;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAll() {
        return ResponseEntity.ok(bookService.findAllDTO());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.findByIdDTO(id));
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<BookDTO> getByIsbn(@PathVariable String isbn) {
        return ResponseEntity.ok(bookService.toDTO(bookService.findByIsbn(isbn)));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchByTitle(@RequestParam String title) {
        return ResponseEntity.ok(bookService.findByTitle(title));
    }

    @GetMapping("/author/{authorId}")
    public ResponseEntity<List<Book>> getByAuthor(@PathVariable Long authorId) {
        return ResponseEntity.ok(bookService.findByAuthor(authorId));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Book>> getByCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(bookService.findByCategory(categoryId));
    }
}
