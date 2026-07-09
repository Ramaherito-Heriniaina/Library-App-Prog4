package library.app.com.endpoint.rest.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Entity
@Table(name = "supplier")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JSupplier {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String contactName;
  private String phone;
  private String email;
  private String address;
  private String registrationNumber; // siret equivalent

  @OneToMany(mappedBy = "supplier")
  private List<JRestocking> restockings;
}
