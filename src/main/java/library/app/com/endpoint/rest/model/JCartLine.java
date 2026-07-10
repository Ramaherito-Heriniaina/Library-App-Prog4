package library.app.com.endpoint.rest.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;

@Entity
@Table(name = "cart_line")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JCartLine {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Integer quantity;
  private LocalDateTime addedAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "cart_id")
  private JCart cart;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "book_id")
  private JBook book;
}
