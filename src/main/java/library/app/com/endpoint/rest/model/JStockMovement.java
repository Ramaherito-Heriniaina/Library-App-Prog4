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

    /**
     * Format de l'édition concernée : "GF", "PF", etc.
     * Nullable : null = mouvement toutes éditions confondues.
     */
    private String format;

    private LocalDate movementDate;
    private String note;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private JBook book;
}
