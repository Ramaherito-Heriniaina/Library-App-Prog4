package library.app.com.repository.model;


import lombok.*;
import library.app.com.repository.enums.CartStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart {
    private String id;
    private Customer customer;
    private CartStatus status;
}