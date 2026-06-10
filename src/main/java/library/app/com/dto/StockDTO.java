package library.app.com.dto;

import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class StockDTO {
    private Long id;
    private Integer quantity;
    private Integer alertThreshold;
    private LocalDateTime lastUpdated;
    private BookDTO book;
}
