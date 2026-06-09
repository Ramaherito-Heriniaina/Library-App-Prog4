package library.app.com.entity;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Author {
    private String id;
    private String firstName;
    private String lastName;
    private String nationality;
}
