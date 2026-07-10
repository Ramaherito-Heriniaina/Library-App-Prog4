package library.app.com.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.*;

@Entity
@Table(name = "payment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private BigDecimal amount;
  private LocalDateTime paymentDate;
  private String reference;

  @Enumerated(EnumType.STRING)
  private PaymentMethod method;

  @Enumerated(EnumType.STRING)
  private PaymentStatus status;

  public enum PaymentMethod {
    CASH,
    CARD,
    MOBILE
  }

  public enum PaymentStatus {
    PENDING,
    COMPLETED,
    FAILED
  }
}
