package library.app.com.entity;

import library.app.com.entity.enums.BookFormat;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class BookCopy {
    private String id;
    private Book book;
    private BookFormat format;
}
