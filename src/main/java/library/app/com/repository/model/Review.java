package library.app.com.repository.model;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {

    private String id;

    private Book book;

    private Member member;

    private Integer rating;

    private String comment;
}