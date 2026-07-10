package library.app.com.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import library.app.com.endpoint.rest.model.JAuthor;
import library.app.com.endpoint.rest.model.JBook;
import library.app.com.endpoint.rest.model.JCategory;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

  private Long id;
  private String title;
  private String isbn;
  private LocalDate publicationDate;
  private BigDecimal priceExTax;
  private BigDecimal priceInclTax;
  private BigDecimal vat;
  private Integer pageCount;
  private String summary;
  private String language;
  private String format;
  private Double weight;
  private Long publisherId;
  private List<Long> authorIds;
  private List<Long> categoryIds;

  public static Book from(JBook j) {
    if (j == null) return null;
    return Book.builder()
        .id(j.getId())
        .title(j.getTitle())
        .isbn(j.getIsbn())
        .publicationDate(j.getPublicationDate())
        .priceExTax(j.getPriceExTax())
        .priceInclTax(j.getPriceInclTax())
        .vat(j.getVat())
        .pageCount(j.getPageCount())
        .summary(j.getSummary())
        .language(j.getLanguage())
        .format(j.getFormat())
        .weight(j.getWeight())
        .publisherId(j.getPublisher() != null ? j.getPublisher().getId() : null)
        .authorIds(
            j.getAuthors() != null
                ? j.getAuthors().stream().map(JAuthor::getId).toList()
                : List.of())
        .categoryIds(
            j.getCategories() != null
                ? j.getCategories().stream().map(JCategory::getId).toList()
                : List.of())
        .build();
  }
}
