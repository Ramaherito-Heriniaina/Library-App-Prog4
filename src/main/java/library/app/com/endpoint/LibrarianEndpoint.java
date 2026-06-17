package library.app.com.endpoint;


import library.app.com.repository.model.Librarian;
import library.app.com.service.LibrarianService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/librarians")
public class LibrarianEndpoint {

    private final LibrarianService service;

    public LibrarianEndpoint(LibrarianService service) {
        this.service = service;
    }

    @GetMapping
    public List<Librarian> getAllLibrarians() {
        return service.getAllLibrarians();
    }

    @DeleteMapping("/{id}")
    public void deleteLibrarian(@PathVariable Long id) {
        service.deleteLibrarian(id);
    }

}
