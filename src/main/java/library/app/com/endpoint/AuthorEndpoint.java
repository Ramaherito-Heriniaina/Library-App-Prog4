package library.app.com.endpoint;

import library.app.com.repository.model.Author;
import library.app.com.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorEndpoint {

    private final AuthorService service;

    public AuthorEndpoint(AuthorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return service.getAllAuthors();
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        service.deleteAuthor(id);
    }
}