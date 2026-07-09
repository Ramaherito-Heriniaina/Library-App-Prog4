package library.app.com.entity;

import library.app.com.endpoint.rest.model.JBook;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.UUID;


@Table(name = "sale_item")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class SaleItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Integer quantity;

    private BigDecimal unitPrice;

    @ManyToOne
    private JBook book;

    @ManyToOne
    private Sale sale;
}