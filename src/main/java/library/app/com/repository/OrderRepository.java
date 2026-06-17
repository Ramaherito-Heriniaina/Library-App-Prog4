package library.app.com.repository;

import library.app.com.repository.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {

    private final List<Order> Orders = new ArrayList<>();

    public List<Order> findAll() {
        return Orders;
    }

    public void deleteById(Long id) {
        Orders.removeIf(Order -> Order.getId().equals(id));
    }
}