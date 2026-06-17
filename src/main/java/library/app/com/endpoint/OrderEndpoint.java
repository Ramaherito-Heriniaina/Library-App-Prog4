package library.app.com.endpoint;


import library.app.com.repository.model.Order;
import library.app.com.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderEndpoint {

    private final OrderService service;

    public OrderEndpoint(OrderService service) {this.service = service;}

    @GetMapping
    public List<Order> getAll() {return service.getAllOrders();}


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {service.deleteOrder(String.valueOf(id));}
}