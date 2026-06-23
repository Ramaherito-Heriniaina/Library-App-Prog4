package library.app.com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import library.app.com.endpoint.rest.model.JAuthor;
import lombok.*;
import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder @Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lastName;
    private String firstName;
    private LocalDate birthDate;
    private String biography;
    private String nationality;

    public static Author from(JAuthor j) {
        if (j == null) return null;
        return Author.builder()
            .id(j.getId())
            .lastName(j.getLastName())
            .firstName(j.getFirstName())
            .birthDate(j.getBirthDate())
            .biography(j.getBiography())
            .nationality(j.getNationality())
            .build();
    }
}
