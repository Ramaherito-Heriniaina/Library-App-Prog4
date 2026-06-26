package library.app.com.endpoint.rest.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "stock_movement")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class JStockMovement {

    public enum Type { IN, OUT }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Type type;

    @Column(nullable = false)
    private Integer quantity;

    private LocalDate movementDate;

    private String note; // ex: "Livraison fournisseur X", "Vente commande #42"

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private JBook book;
}
