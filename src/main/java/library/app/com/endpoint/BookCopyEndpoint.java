package library.app.com.endpoint;

import library.app.com.repository.model.BookCopy;
import library.app.com.service.BookCopyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book-copies")
public class BookCopyEndpoint {

    private final BookCopyService service;

    public BookCopyEndpoint(BookCopyService service) {
        this.service = service;
    }

    @GetMapping
    public List<BookCopy> getAll() {
        return service.getAllBookCopies();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteBookCopy(String.valueOf(id));
    }
}