package library.app.com.endpoint.rest.controller.health;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<AuthorDTO>> getAll() {
        return ResponseEntity.ok(authorService.findAllDTO());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.findByIdDTO(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<AuthorDTO>> searchByLastName(@RequestParam String lastName) {
        return ResponseEntity.ok(
            authorService.findByLastName(lastName).stream()
                .map(AuthorService::toDTO).toList()
        );
    }
}
