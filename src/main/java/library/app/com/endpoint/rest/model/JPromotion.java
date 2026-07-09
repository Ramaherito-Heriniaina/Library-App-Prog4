package library.app.com.endpoint.rest.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import lombok.*;

@Entity
@Table(name = "promotion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JPromotion {

  public enum DiscountType {
    PERCENTAGE,
    FIXED_AMOUNT
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, nullable = false)
  private String code;

  @Column(columnDefinition = "TEXT")
  private String description;

  private LocalDate startDate;
  private LocalDate endDate;

  @Enumerated(EnumType.STRING)
  private DiscountType discountType;

  @Column(precision = 10, scale = 2)
  private BigDecimal discountValue;

  private Integer maxUses;
  private Integer currentUses;

  @OneToMany(mappedBy = "promotion", cascade = CascadeType.ALL)
  private List<JPromotionBook> promotionBooks;
}
