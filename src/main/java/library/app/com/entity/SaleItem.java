package library.app.com.entity;

import lombok.*;
import java.math.BigDecimal;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class SaleItem {
    private String id;
    private int quantity;
    private BigDecimal unitPrice;

}
