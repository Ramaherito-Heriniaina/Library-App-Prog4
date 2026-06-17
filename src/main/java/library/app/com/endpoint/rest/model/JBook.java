package library.app.com.endpoint.rest.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "book")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class JBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(unique = true)
    private String isbn;

    private LocalDate publicationDate;

    @Column(precision = 10, scale = 2)
    private BigDecimal priceExTax;

    @Column(precision = 10, scale = 2)
    private BigDecimal priceInclTax;

    @Column(precision = 5, scale = 2)
    private BigDecimal vat;

    private Integer pageCount;

    @Column(columnDefinition = "TEXT")
    private String summary;

    private String language;
    private String format;
    private Double weight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id")
    private JPublisher publisher;

    @ManyToMany
    @JoinTable(
        name = "book_author",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<JAuthor> authors;

    @ManyToMany
    @JoinTable(
        name = "book_category",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<JCategory> categories;

    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
    private JStock stock;
}
