package library.app.com.endpoint.rest.controller.health;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAll() {
        return ResponseEntity.ok(orderService.findAllDTO());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.findByIdDTO(id));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<OrderDTO>> getByCustomer(@PathVariable Long customerId) {
        return ResponseEntity.ok(
            orderService.findByCustomer(customerId).stream()
                .map(orderService::toDTO).toList()
        );
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<OrderDTO>> getByStatus(@PathVariable Order.OrderStatus status) {
        return ResponseEntity.ok(
            orderService.findByStatus(status).stream()
                .map(orderService::toDTO).toList()
        );
    }
}
