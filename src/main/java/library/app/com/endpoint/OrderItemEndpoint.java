package library.app.com.endpoint;


import library.app.com.repository.model.OrderItem;
import library.app.com.service.OrderItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-items")
public class OrderItemEndpoint {

    private final OrderItemService service;

    public OrderItemEndpoint(OrderItemService service) {this.service = service;}

    @GetMapping
    public List<OrderItem> getAll() {return service.getAllOrderItems();}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {service.deleteOrderItem(String.valueOf(id));}
}