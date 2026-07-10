package library.app.com.endpoint.rest.controller.health;

import java.util.List;
import library.app.com.endpoint.rest.model.JBook;
import library.app.com.entity.Book;
import library.app.com.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
import java.security.Provider;
import java.util.List;

=======
>>>>>>> feat/sale
@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

  private final BookService service;

<<<<<<< HEAD
    @GetMapping
    public List<Book> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int pageSize) {
        return service.getAll(page, pageSize);
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public JBook updateBook(@PathVariable Long id, @RequestBody JBook book) {
        return service.updateBook(id, book);
    }

    @DeleteMapping("/{id}")

    public void deleteBook(@PathVariable Long id) {

        service.deleteBook(id);

    }
=======
  @GetMapping
  public List<Book> getAll(
      @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int pageSize) {

    return service.getAll(page, pageSize);
  }

  @GetMapping("/{id}")
  public Book getById(@PathVariable Long id) {

    return service.getById(id);
  }

  @PostMapping
  public Book create(@RequestBody JBook book) {

    return service.create(book);
  }

  @PutMapping("/{id}")
  public JBook updateBook(@PathVariable Long id, @RequestBody JBook book) {

    return service.updateBook(id, book);
  }

  @DeleteMapping("/{id}")
  public void deleteBook(@PathVariable Long id) {

    service.deleteBook(id);
  }
>>>>>>> feat/sale
}
