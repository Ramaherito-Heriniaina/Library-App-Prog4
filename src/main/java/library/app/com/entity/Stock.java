package library.app.com.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Stock {
    private String id;
    private int quantity;
}
