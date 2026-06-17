package library.app.com.endpoint.rest.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "author")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class JAuthor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lastName;
    private String firstName;
    private LocalDate birthDate;

    @Column(columnDefinition = "TEXT")
    private String biography;

    private String nationality;

    @ManyToMany(mappedBy = "authors")
    private List<JBook> books;
}
