package library.app.com.dto;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class SaleDTO {
    private Long id;
    private LocalDateTime saleDate;
    private BigDecimal totalAmount;
    private String status;
    private CustomerDTO customer;
    private List<com.librairie.dto.SaleItemDTO> saleItems;
}
