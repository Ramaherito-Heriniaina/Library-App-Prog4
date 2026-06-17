package library.app.com.entity;

import library.app.com.endpoint.rest.model.JBook;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "book_copy")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class BookCopy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String format;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private JBook book;  // ← JBook au lieu de Book
}