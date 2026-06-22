package library.app.com.repository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import library.app.com.PojaGenerated;
import lombok.Getter;
import lombok.Setter;

@PojaGenerated
@Entity
@Getter
@Setter
public class Dummy {
  @Id private String id;
}
