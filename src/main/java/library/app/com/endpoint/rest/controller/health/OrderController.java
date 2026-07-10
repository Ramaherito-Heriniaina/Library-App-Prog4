package library.app.com.endpoint.rest.controller.health;

import java.util.List;
import library.app.com.entity.Order;
import library.app.com.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

  private final OrderService service;

  @GetMapping
  public List<Order> getAll(
      @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int pageSize) {
    return service.getAll(page, pageSize);
  }

  @GetMapping("/{id}")
  public Order getById(@PathVariable Long id) {
    return service.getById(id);
  }
}
