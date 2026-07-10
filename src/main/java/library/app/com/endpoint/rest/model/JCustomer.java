package library.app.com.endpoint.rest.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import lombok.*;

@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JCustomer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String lastName;
  private String firstName;

  @Column(unique = true, nullable = false)
  private String email;

  private String phone;
  private String address;
  private LocalDate registrationDate;
  private String password;
  private Integer loyaltyPoints;
  private Boolean active;

  @OneToMany(mappedBy = "customer")
  private List<JOrder> orders;

  @OneToMany(mappedBy = "customer")
  private List<JReview> reviews;

  @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
  private JCart cart;
}
