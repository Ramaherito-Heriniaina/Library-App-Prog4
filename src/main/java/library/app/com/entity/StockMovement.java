package library.app.com.entity;

import java.time.LocalDate;
import library.app.com.endpoint.rest.model.JStockMovement;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockMovement {

  private Long id;
  private JStockMovement.Type type;
  private Integer quantity;
  private LocalDate movementDate;
  private String note;
  private Long bookId;

  public static StockMovement from(JStockMovement j) {
    if (j == null) return null;
    return StockMovement.builder()
        .id(j.getId())
        .type(j.getType())
        .quantity(j.getQuantity())
        .movementDate(j.getMovementDate())
        .note(j.getNote())
        .bookId(j.getBook() != null ? j.getBook().getId() : null)
        .build();
  }
}
