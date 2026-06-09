package library.app.com.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class BookCopy {
    private String id;
    private Book book;
    private Format format;
}
