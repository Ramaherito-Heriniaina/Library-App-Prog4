package library.app.com.entity;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Order {
    private String id;
    private LocalDateTime orderDate;
    private int quantity;
    private OrderStatus orderStatus;
}
