package library.app.com.endpoint.rest.controller.health;

import library.app.com.entity.OrderLine;
import library.app.com.service.OrderLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-lines")
@RequiredArgsConstructor
public class OrderLineController {

    private final OrderLineService service;

    @GetMapping
    public List<OrderLine> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int pageSize) {
        return service.getAll(page, pageSize);
    }

    @GetMapping("/{id}")
    public OrderLine getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public OrderLine create(@RequestBody OrderLine orderLine) {
        return service.createOrUpdate(orderLine);
    }

    @PutMapping("/{id}")
    public OrderLine update(@PathVariable Long id, @RequestBody OrderLine orderLine) {
        orderLine.setId(id);
        return service.createOrUpdate(orderLine);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}