package library.app.com.entity;

import library.app.com.endpoint.rest.model.JBook;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "sale_item")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class SaleItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;
    private BigDecimal unitPrice;
    private BigDecimal discount;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private JBook book;
}