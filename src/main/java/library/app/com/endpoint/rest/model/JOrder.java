package library.app.com.endpoint.rest.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import lombok.*;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JOrder {

  public enum Status {
    PENDING,
    CONFIRMED,
    SHIPPED,
    DELIVERED,
    CANCELLED
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDate orderDate;

  @Enumerated(EnumType.STRING)
  private Status status;

  @Column(precision = 10, scale = 2)
  private BigDecimal totalExTax;

  @Column(precision = 10, scale = 2)
  private BigDecimal totalInclTax;

  private LocalDate deliveryDate;
  private String deliveryAddress;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "customer_id")
  private JCustomer customer;

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
  private List<JOrderLine> orderLines;

  @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
  private JPayment payment;
}
