package library.app.com.repository.model;


import lombok.*;
import library.app.com.repository.enums.BookFormat;
import library.app.com.repository.enums.Language;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    private String id;
    private String title;
    private String isbn;
    private Integer publicationYear;

    private Author author;
    private Category category;
    private Publisher publisher;

    private Language language;
    private BookFormat format;

    private Integer totalCopies;
    private Integer availableCopies;
}