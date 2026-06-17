package library.app.com.entity;

import library.app.com.endpoint.rest.model.JOrderLine;
import lombok.*;
import java.math.BigDecimal;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class OrderLine {

    private Long id;
    private Integer quantity;
    private BigDecimal unitPrice;
    private BigDecimal discount;
    private Long orderId;
    private Long bookId;

    public static OrderLine from(JOrderLine j) {
        if (j == null) return null;
        return OrderLine.builder()
            .id(j.getId())
            .quantity(j.getQuantity())
            .unitPrice(j.getUnitPrice())
            .discount(j.getDiscount())
            .orderId(j.getOrder() != null ? j.getOrder().getId() : null)
            .bookId(j.getBook() != null ? j.getBook().getId() : null)
            .build();
    }
}
