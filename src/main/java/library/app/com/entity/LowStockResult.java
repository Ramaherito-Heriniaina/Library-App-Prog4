package library.app.com.entity;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class LowStockResult {

    private Long bookId;
    private String title;
    private String isbn;
    private Integer currentStock;   // quantité calculée
    private Integer alertThreshold; // seuil d'alerte défini sur JStock
    private String location;
}
