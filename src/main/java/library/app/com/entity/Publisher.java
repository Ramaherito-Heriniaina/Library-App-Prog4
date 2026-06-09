package library.app.com.entity;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Publisher {
    private String id;
    private String name;
    private String email;
    private String phone;
}
