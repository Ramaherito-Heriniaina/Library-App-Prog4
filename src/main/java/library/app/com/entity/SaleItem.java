package library.app.com.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import library.app.com.endpoint.rest.model.JBook;
import lombok.*;

@Entity
@Table(name = "sale_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleItem {

  @Id // ← déplacé ici
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id; // ← type Long, pas Integer

  private Integer quantity;
  private BigDecimal unitPrice;
  private BigDecimal discount;

  @ManyToOne
  @JoinColumn(name = "book_id")
  private JBook book;
}
