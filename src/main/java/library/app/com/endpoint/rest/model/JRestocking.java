package library.app.com.endpoint.rest.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import lombok.*;

@Entity
@Table(name = "restocking")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JRestocking {

  public enum Status {
    PENDING,
    ORDERED,
    RECEIVED,
    CANCELLED
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDate orderDate;
  private LocalDate receivedDate;

  @Column(precision = 10, scale = 2)
  private BigDecimal totalAmount;

  @Enumerated(EnumType.STRING)
  private Status status;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "supplier_id")
  private JSupplier supplier;

  @ManyToMany
  @JoinTable(
      name = "restocking_book",
      joinColumns = @JoinColumn(name = "restocking_id"),
      inverseJoinColumns = @JoinColumn(name = "book_id"))
  private List<JBook> books;
}
