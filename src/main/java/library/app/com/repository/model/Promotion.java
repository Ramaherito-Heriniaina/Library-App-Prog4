package library.app.com.repository.model;


import lombok.*;
import library.app.com.repository.enums.DiscountType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Promotion {

    private String id;
    private String name;
    private String description;
    private Double value;
    private DiscountType discountType;
}