package library.app.com.entity;

import library.app.com.entity.enums.Genre;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Book {
    private String id;
    private String title;
    private String isbn;
    private BigDecimal price;
    private String language;
    private Genre genre;
    private LocalDate publishedDate;
}
