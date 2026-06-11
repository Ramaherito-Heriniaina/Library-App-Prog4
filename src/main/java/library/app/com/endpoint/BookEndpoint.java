package library.app.com.endpoint;

import library.app.com.entity.Book;
import library.app.com.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookEndpoint {

    private final BookService bookService;

    @PutMapping("/{id}")
    public Book updateBook(
            @PathVariable String id,
            @RequestBody Book book) {

        return bookService.updateBook(id, book);
    }
}