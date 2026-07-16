package library.app.com.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookVerificationResult {

  private boolean found;
  private String source; // "OpenLibrary", "GoogleBooks", ou null si non trouvé

  // Infos du livre récupérées
  private String isbn;
  private String title;
  private String author;
  private String publishedDate;
  private String description;
  private String coverUrl;
  private Integer pageCount;
  private String publisher;
}
