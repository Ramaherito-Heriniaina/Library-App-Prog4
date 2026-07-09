package library.app.com.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import library.app.com.endpoint.rest.model.JEmployee;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

  private Long id;
  private String lastName;
  private String firstName;
  private String position;
  private BigDecimal salary;
  private LocalDate hireDate;
  private String email;
  private String phone;

  public static Employee from(JEmployee j) {
    if (j == null) return null;
    return Employee.builder()
        .id(j.getId())
        .lastName(j.getLastName())
        .firstName(j.getFirstName())
        .position(j.getPosition())
        .salary(j.getSalary())
        .hireDate(j.getHireDate())
        .email(j.getEmail())
        .phone(j.getPhone())
        .build();
  }
}
