package library.app.com.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import library.app.com.endpoint.rest.model.JSale;
import lombok.*;

@Table(name = "sales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sale {

  private Long id;
  private LocalDateTime saleDate;
  private BigDecimal totalAmount;

  public static Sale from(JSale jSale) {
    if (jSale == null) {
      return null;
    }

    return Sale.builder()
        .id(jSale.getId())
        .saleDate(jSale.getSaleDate())
        .totalAmount(jSale.getTotalAmount())
        .build();
  }
}
