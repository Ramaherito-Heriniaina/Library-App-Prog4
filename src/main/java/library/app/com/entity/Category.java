package library.app.com.entity;

import library.app.com.endpoint.rest.model.JCategory;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

  private Long id;
  private String name;
  private String description;
  private Long parentId;

  public static Category from(JCategory j) {
    if (j == null) return null;
    return Category.builder()
        .id(j.getId())
        .name(j.getName())
        .description(j.getDescription())
        .parentId(j.getParent() != null ? j.getParent().getId() : null)
        .build();
  }
}
