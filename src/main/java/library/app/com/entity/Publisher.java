package library.app.com.entity;

import library.app.com.endpoint.rest.model.JPublisher;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Publisher {

    private Long id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String website;

    public static Publisher from(JPublisher j) {
        if (j == null) return null;
        return Publisher.builder()
            .id(j.getId())
            .name(j.getName())
            .address(j.getAddress())
            .phone(j.getPhone())
            .email(j.getEmail())
            .website(j.getWebsite())
            .build();
    }
}
