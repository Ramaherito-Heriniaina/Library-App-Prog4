package library.app.com.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class PublisherDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
}
