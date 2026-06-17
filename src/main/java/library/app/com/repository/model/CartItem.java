package library.app.com.repository.model;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItem {
    private String id;
    private Cart cart;
    private Book book;
    private Integer quantity;
}