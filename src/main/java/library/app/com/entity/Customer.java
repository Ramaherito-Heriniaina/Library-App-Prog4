package library.app.com.entity;

import java.time.LocalDate;
import library.app.com.endpoint.rest.model.JCustomer;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

  private Long id;
  private String lastName;
  private String firstName;
  private String email;
  private String phone;
  private String address;
  private LocalDate registrationDate;
  private Integer loyaltyPoints;
  private Boolean active;

  public static Customer from(JCustomer j) {
    if (j == null) return null;
    return Customer.builder()
        .id(j.getId())
        .lastName(j.getLastName())
        .firstName(j.getFirstName())
        .email(j.getEmail())
        .phone(j.getPhone())
        .address(j.getAddress())
        .registrationDate(j.getRegistrationDate())
        .loyaltyPoints(j.getLoyaltyPoints())
        .active(j.getActive())
        .build();
  }
}
