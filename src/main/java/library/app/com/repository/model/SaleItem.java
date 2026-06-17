package library.app.com.repository.model;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleItem {
    private String id;
    private Sale sale;
    private Book book;
    private Integer quantity;
    private Double price;
}