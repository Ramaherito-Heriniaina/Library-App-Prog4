package library.app.com.entity;

import java.time.LocalDateTime;
import library.app.com.endpoint.rest.model.JStock;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Stock {

  private Long id;
  private Integer quantity;
  private Integer alertThreshold;
  private String location;
  private LocalDateTime lastUpdated;
  private Long bookId;

  public static Stock from(JStock j) {
    if (j == null) return null;
    return Stock.builder()
        .id(j.getId())
        .quantity(j.getQuantity())
        .alertThreshold(j.getAlertThreshold())
        .location(j.getLocation())
        .lastUpdated(j.getLastUpdated())
        .bookId(j.getBook() != null ? j.getBook().getId() : null)
        .build();
  }
}
