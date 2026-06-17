package library.app.com.repository.model;


import lombok.*;
import library.app.com.repository.enums.RestockingStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Stock {

    private String id;

    private Book book;

    private Integer quantity;

    private RestockingStatus status;
}