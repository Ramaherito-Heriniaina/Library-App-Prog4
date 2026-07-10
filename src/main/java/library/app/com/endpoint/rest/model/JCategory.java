package library.app.com.endpoint.rest.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Entity
@Table(name = "category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JCategory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @Column(columnDefinition = "TEXT")
  private String description;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "parent_id")
  private JCategory parent;

  @OneToMany(mappedBy = "parent")
  private List<JCategory> subCategories;

  @ManyToMany(mappedBy = "categories")
  private List<JBook> books;
}
