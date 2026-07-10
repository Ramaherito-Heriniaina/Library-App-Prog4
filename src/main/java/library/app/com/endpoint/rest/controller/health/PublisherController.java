package library.app.com.endpoint.rest.controller.health;

import java.util.List;
import library.app.com.entity.Publisher;
import library.app.com.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/publishers")
@RequiredArgsConstructor
public class PublisherController {

  private final PublisherService service;

  @GetMapping
  public List<Publisher> getAll(
      @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int pageSize) {
    return service.getAll(page, pageSize);
  }

  @GetMapping("/{id}")
  public Publisher getById(@PathVariable Long id) {
    return service.getById(id);
  }
}
