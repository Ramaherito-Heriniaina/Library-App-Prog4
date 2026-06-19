package library.app.com.endpoint.rest.controller.health;

import library.app.com.endpoint.rest.model.JBook;
import library.app.com.entity.Book;
import library.app.com.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Provider;
import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

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
}
