package library.app.com.endpoint.rest.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Entity
@Table(name = "publisher")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JPublisher {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String address;
  private String phone;
  private String email;
  private String website;

  @OneToMany(mappedBy = "publisher")
  private List<JBook> books;
}
