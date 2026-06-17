package library.app.com.service;

import library.app.com.entity.Order;
import library.app.com.exception.NotFoundException;
import library.app.com.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;

    public List<Order> getAll(int page, int pageSize) {
        return repository.findAll(PageRequest.of(page, pageSize))
                .stream()
                .map(Order::from)
                .toList();
    }

    public Order getById(Long id) {
        return repository.findById(id)
                .map(Order::from)
                .orElseThrow(() -> new NotFoundException("Order #" + id + " not found"));
    }
}
