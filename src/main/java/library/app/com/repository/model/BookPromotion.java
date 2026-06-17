package library.app.com.repository.model;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookPromotion {
    private String id;
    private Book book;
    private Promotion promotion;
}