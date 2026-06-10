package library.app.com.repository.model;

import java.time.LocalDate;

public class Member {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private LocalDate registrationDate;

    public Member() {
    }

    public Member(Long id, String firstName, String lastName,
                  String email, String phone,
                  String address,
                  LocalDate registrationDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.registrationDate = registrationDate;
    }

    // Getters & Setters
}