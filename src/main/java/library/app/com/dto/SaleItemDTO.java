package library.app.com.dto;

import lombok.*;
import java.math.BigDecimal;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class SaleItemDTO {
    private Long id;
    private Integer quantity;
    private BigDecimal unitPrice;
    private BookDTO book;
}
