package library.app.com.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;
import library.app.com.endpoint.rest.model.JBook;
import lombok.*;

@Table(name = "sale_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Integer quantity;

    private BigDecimal unitPrice;

    @ManyToOne private JBook book;

    @ManyToOne private Sale sale;
}