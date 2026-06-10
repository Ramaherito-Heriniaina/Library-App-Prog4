package library.app.com.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class AuthorDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String nationality;
}
