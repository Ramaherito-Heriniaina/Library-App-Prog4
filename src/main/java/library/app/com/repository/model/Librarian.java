package library.app.com.repository.model;


import lombok.*;
import library.app.com.repository.enums.UserRole;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Librarian {
    private String id;
    private String firstName;
    private String lastName;
    private String email;

    private UserRole role;
}