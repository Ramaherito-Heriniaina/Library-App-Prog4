package library.app.com.dto;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class BookDTO {
    private Long id;
    private String title;
    private String isbn;
    private LocalDate publicationDate;
    private BigDecimal priceIncludingTax;
    private String language;
    private String format;
    private com.librairie.dto.PublisherDTO publisher;
    private List<AuthorDTO> authors;
    private List<com.librairie.dto.CategoryDTO> categories;
}
