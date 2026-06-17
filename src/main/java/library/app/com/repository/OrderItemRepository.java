package library.app.com.repository;

import library.app.com.repository.model.OrderItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderItemRepository {

    private final List<OrderItem> OrderItems = new ArrayList<>();

    public List<OrderItem> findAll() {
        return OrderItems;
    }

    public void deleteById(Long id) {
        OrderItems.removeIf(OrderItem -> OrderItem.getId().equals(id));
    }
}