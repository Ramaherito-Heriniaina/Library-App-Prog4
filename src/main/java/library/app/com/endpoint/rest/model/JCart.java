package library.app.com.endpoint.rest.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "cart")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class JCart {

    public enum Status { ACTIVE, CHECKED_OUT, ABANDONED }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private JCustomer customer;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JCartLine> cartLines;
}
