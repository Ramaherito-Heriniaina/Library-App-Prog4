package library.app.com.repository.model;


import lombok.*;
import library.app.com.repository.enums.OrderStatus;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    private String id;
    private Customer customer;
    private LocalDate orderDate;
    private Double totalAmount;
    private OrderStatus status;
}