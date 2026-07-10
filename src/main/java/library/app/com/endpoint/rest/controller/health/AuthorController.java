package library.app.com.endpoint.rest.controller.health;

import java.util.List;
import library.app.com.entity.Author;
import library.app.com.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

  private final AuthorService service;

  @GetMapping
  public List<Author> getAll(
      @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int pageSize) {
    return service.getAll(page, pageSize);
  }

  @GetMapping("/{id}")
  public Author getById(@PathVariable Long id) {
    return service.getById(id);
  }
}
