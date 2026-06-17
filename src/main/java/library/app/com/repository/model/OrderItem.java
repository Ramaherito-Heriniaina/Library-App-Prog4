package library.app.com.repository.model;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {
    private String id;
    private Order order;
    private Book book;
    private Integer quantity;
    private Double price;
}