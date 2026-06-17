package library.app.com.repository.model;



import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fine {
    private String id;
    private Member member;
    private Double amount;
    private Boolean paid;
}