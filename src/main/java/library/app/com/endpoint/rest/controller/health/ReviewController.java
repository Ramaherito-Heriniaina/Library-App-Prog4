package library.app.com.endpoint.rest.controller.health;

import java.util.List;
import library.app.com.entity.Review;
import library.app.com.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

  private final ReviewService service;

  @GetMapping
  public List<Review> getAll(
      @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int pageSize) {
    return service.getAll(page, pageSize);
  }

  @GetMapping("/{id}")
  public Review getById(@PathVariable Long id) {
    return service.getById(id);
  }
}
