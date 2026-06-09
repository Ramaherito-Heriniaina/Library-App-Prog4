package library.app.com.entity;

import lombok.*;
import java.math.BigDecimal;


@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class OrderItem {
    private String id;
    private int quantity;
    private BigDecimal unitPrice;

}
