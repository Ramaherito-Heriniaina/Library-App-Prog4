package library.app.com.entity;

import java.time.LocalDateTime;
import library.app.com.endpoint.rest.model.JReview;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {

  private Long id;
  private Integer rating;
  private String comment;
  private LocalDateTime createdAt;
  private Long customerId;
  private Long bookId;

  public static Review from(JReview j) {
    if (j == null) return null;
    return Review.builder()
        .id(j.getId())
        .rating(j.getRating())
        .comment(j.getComment())
        .createdAt(j.getCreatedAt())
        .customerId(j.getCustomer() != null ? j.getCustomer().getId() : null)
        .bookId(j.getBook() != null ? j.getBook().getId() : null)
        .build();
  }
}
