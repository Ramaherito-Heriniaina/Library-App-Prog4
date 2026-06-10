package library.app.com.repository.model;


public class Librarian {

    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String role;

    public Librarian() {
    }

    public Librarian(Long id,
                     String username,
                     String password,
                     String firstName,
                     String lastName,
                     String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    // Getters & Setters
}