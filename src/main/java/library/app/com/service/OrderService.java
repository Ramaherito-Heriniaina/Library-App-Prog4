package library.app.com.service;


import library.app.com.repository.model.Order;
import library.app.com.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {this.repository = repository;}

    public List<Order> getAllOrders() {return repository.findAll();}

    public void deleteOrder(String id) {repository.deleteById(Long.valueOf(id));}
}