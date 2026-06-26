package library.app.com.entity;

import library.app.com.endpoint.rest.model.JStock;
import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Stock {

    private Long id;
    private Integer quantity;          // TOUJOURS calculée (IN - OUT), jamais stockée
    private Integer alertThreshold;
    private String location;
    private LocalDateTime lastUpdated;
    private Long bookId;

    /**
     * Construit un Stock à partir de l'entité JStock + la quantité déjà calculée
     * (somme des mouvements IN - OUT), fournie par le service.
     * Il n'existe volontairement aucun constructeur/builder qui accepte
     * une quantity arbitraire sans passer par ce calcul.
     */
    public static Stock from(JStock j, int computedQuantity) {
        if (j == null) return null;
        return Stock.builder()
                .id(j.getId())
                .quantity(computedQuantity)
                .alertThreshold(j.getAlertThreshold())
                .location(j.getLocation())
                .lastUpdated(j.getLastUpdated())
                .bookId(j.getBook() != null ? j.getBook().getId() : null)
                .build();
    }
}
