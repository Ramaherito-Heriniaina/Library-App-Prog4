package library.app.com.endpoint.rest.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.*;

@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JEmployee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String lastName;
  private String firstName;
  private String position;

  @Column(precision = 10, scale = 2)
  private BigDecimal salary;

  private LocalDate hireDate;

  @Column(unique = true)
  private String email;

  private String phone;
}
