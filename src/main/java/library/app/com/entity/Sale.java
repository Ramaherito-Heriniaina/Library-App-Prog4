package library.app.com.entity;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Sale {

    private int id;
    private LocalDateTime saleDate;
    private BigDecimal totalAmount;
}
