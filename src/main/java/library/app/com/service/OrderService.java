package library.app.com.service;

import com.librairie.dto.OrderDTO;
import com.librairie.dto.OrderItemDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
    }

    public List<Order> findByCustomer(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    public List<Order> findByStatus(Order.OrderStatus status) {
        return orderRepository.findByStatus(status);
    }

    public OrderDTO toDTO(Order order) {
        return OrderDTO.builder()
                .id(order.getId())
                .orderDate(order.getOrderDate())
                .totalAmount(order.getTotalAmount())
                .status(order.getStatus().name())
                .customer(order.getCustomer() != null ?
                    CustomerService.toDTO(order.getCustomer()) : null)
                .orderItems(order.getOrderItems() != null ?
                    order.getOrderItems().stream().map(item ->
                        OrderItemDTO.builder()
                            .id(item.getId())
                            .quantity(item.getQuantity())
                            .unitPrice(item.getUnitPrice())
                            .build()
                    ).collect(Collectors.toList()) : null)
                .build();
    }

    public List<OrderDTO> findAllDTO() {
        return findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public OrderDTO findByIdDTO(Long id) {
        return toDTO(findById(id));
    }
}
