package library.app.com.endpoint.rest.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "promotion_book")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class JPromotionBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(precision = 5, scale = 2)
    private BigDecimal discountPercent;

    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "promotion_id")
    private JPromotion promotion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private JBook book;
}
