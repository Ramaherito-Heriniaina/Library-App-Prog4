package library.app.com.endpoint.rest.controller.health;

import java.util.List;
import library.app.com.entity.OrderLine;
import library.app.com.service.OrderLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order-lines")
@RequiredArgsConstructor
public class OrderLineController {

  private final OrderLineService service;

  @GetMapping
  public List<OrderLine> getAll(
      @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int pageSize) {
    return service.getAll(page, pageSize);
  }

  @GetMapping("/{id}")
  public OrderLine getById(@PathVariable Long id) {
    return service.getById(id);
  }
}
