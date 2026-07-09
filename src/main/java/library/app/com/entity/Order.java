package library.app.com.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import library.app.com.endpoint.rest.model.JOrder;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

  private Long id;
  private LocalDate orderDate;
  private JOrder.Status status;
  private BigDecimal totalExTax;
  private BigDecimal totalInclTax;
  private LocalDate deliveryDate;
  private String deliveryAddress;
  private Long customerId;

  public static Order from(JOrder j) {
    if (j == null) return null;
    return Order.builder()
        .id(j.getId())
        .orderDate(j.getOrderDate())
        .status(j.getStatus())
        .totalExTax(j.getTotalExTax())
        .totalInclTax(j.getTotalInclTax())
        .deliveryDate(j.getDeliveryDate())
        .deliveryAddress(j.getDeliveryAddress())
        .customerId(j.getCustomer() != null ? j.getCustomer().getId() : null)
        .build();
  }
}
