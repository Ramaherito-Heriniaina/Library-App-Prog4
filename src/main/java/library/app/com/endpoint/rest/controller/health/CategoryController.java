package library.app.com.endpoint.rest.controller.health;

import java.util.List;
import library.app.com.entity.Category;
import library.app.com.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

  private final CategoryService service;

  @GetMapping
  public List<Category> getAll(
      @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int pageSize) {
    return service.getAll(page, pageSize);
  }

  @GetMapping("/{id}")
  public Category getById(@PathVariable Long id) {
    return service.getById(id);
  }
}
