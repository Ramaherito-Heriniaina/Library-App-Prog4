package library.app.com.repository.model;


import lombok.*;
import library.app.com.repository.enums.PaymentMethod;
import library.app.com.repository.enums.PaymentStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {
    private String id;
    private Order order;
    private Double amount;

    private PaymentMethod paymentMethod;
    private PaymentStatus status;
}