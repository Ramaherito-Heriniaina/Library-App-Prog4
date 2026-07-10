package library.app.com.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import library.app.com.endpoint.rest.model.JBook;
import library.app.com.endpoint.rest.model.JOrder;
import lombok.*;

@Entity
@Table(name = "order_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Integer quantity;
  private BigDecimal unitPrice;
  private BigDecimal discount;

  @ManyToOne
  @JoinColumn(name = "order_id")
  private JOrder order; // ← JOrder au lieu de Order

  @ManyToOne
  @JoinColumn(name = "book_id")
  private JBook book; // ← JBook au lieu de Book
}
