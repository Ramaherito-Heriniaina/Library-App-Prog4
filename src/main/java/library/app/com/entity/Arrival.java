package library.app.com.entity;

import java.time.LocalDate;
import library.app.com.endpoint.rest.model.JArrival;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Arrival {

  private Long id;
  private Integer quantity;
  private LocalDate arrivalDate;
  private String note;
  private Long bookId;

  public static Arrival from(JArrival j) {
    if (j == null) return null;
    return Arrival.builder()
        .id(j.getId())
        .quantity(j.getQuantity())
        .arrivalDate(j.getArrivalDate())
        .note(j.getNote())
        .bookId(j.getBook() != null ? j.getBook().getId() : null)
        .build();
  }
}
