package library.app.com.endpoint.rest.controller.health;

import java.util.List;
import library.app.com.entity.Arrival;
import library.app.com.service.ArrivalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/arrivals")
@RequiredArgsConstructor
public class ArrivalController {

  private final ArrivalService service;

  @GetMapping
  public List<Arrival> getAll(
      @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int pageSize) {
    return service.getAll(page, pageSize);
  }

  @GetMapping("/{id}")
  public Arrival getById(@PathVariable Long id) {
    return service.getById(id);
  }

  @GetMapping("/by-book/{bookId}")
  public List<Arrival> getByBookId(@PathVariable Long bookId) {
    return service.getByBookId(bookId);
  }
}
