package library.app.com.repository.model;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookCopy {
    private String id;
    private String barcode;
    private Boolean available;
    private Book book;
}