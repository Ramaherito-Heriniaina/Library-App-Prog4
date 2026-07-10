package library.app.com.endpoint.rest.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.*;

@Entity
@Table(name = "arrival")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JArrival {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Integer quantity;
  private LocalDate arrivalDate;
  private String note; // ex: "Livraison fournisseur X", "Réassort"

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "book_id")
  private JBook book;
}
