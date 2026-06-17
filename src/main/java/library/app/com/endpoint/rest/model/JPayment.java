package library.app.com.endpoint.rest.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "payment")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class JPayment {

    public enum Method { CARD, BANK_TRANSFER, CASH, CHECK, PAYPAL }
    public enum Status { PENDING, VALIDATED, REJECTED, REFUNDED }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(precision = 10, scale = 2)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private Method method;

    private LocalDate paymentDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String reference;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private JOrder order;

    @OneToOne(mappedBy = "payment", cascade = CascadeType.ALL)
    private JInvoice invoice;
}
