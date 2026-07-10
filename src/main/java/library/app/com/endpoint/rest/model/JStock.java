package library.app.com.endpoint.rest.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;

@Entity
@Table(name = "stock")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JStock {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Integer quantity;
  private Integer alertThreshold;
  private String location;
  private LocalDateTime lastUpdated;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "book_id")
  private JBook book;
}
