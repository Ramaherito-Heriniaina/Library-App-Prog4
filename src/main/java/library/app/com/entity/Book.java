package library.app.com.entity;

import jakarta.persistence.*;
import library.app.com.entity.enums.Genre;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String title;

    @Column(unique = true, nullable = false)
    private String isbn;

    @Column(nullable = false)
    private BigDecimal price;

    private String language;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private LocalDate publishedDate;
}