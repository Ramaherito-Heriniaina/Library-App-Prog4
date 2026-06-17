package library.app.com.repository.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}