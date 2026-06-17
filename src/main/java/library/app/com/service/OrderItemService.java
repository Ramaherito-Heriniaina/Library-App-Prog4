package library.app.com.service;


import library.app.com.repository.model.OrderItem;
import library.app.com.repository.OrderItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {

    private final OrderItemRepository repository;

    public OrderItemService(OrderItemRepository repository) {this.repository = repository;}

    public List<OrderItem> getAllOrderItems() {return repository.findAll();}

    public void deleteOrderItem(String id) {repository.deleteById(Long.valueOf(id));}
}