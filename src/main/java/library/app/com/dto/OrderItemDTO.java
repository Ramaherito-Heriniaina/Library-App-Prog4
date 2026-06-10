package library.app.com.dto;

import library.app.com.dto.BookDTO;
import lombok.*;
import java.math.BigDecimal;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class OrderItemDTO {
    private Long id;
    private Integer quantity;
    private BigDecimal unitPrice;
    private BookDTO book;
}
