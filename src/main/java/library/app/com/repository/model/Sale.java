package library.app.com.repository.model;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sale {
    private String id;
    private LocalDate saleDate;
    private Double totalAmount;
}