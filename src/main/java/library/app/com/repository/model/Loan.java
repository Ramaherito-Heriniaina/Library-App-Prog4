package library.app.com.repository.model;


import java.time.LocalDate;

public class Loan {

    private Long id;
    private Book book;
    private Member member;

    private LocalDate loanDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    private String status;

    public Loan() {
    }

    public Loan(Long id, Book book, Member member,
                LocalDate loanDate,
                LocalDate dueDate,
                LocalDate returnDate,
                String status) {
        this.id = id;
        this.book = book;
        this.member = member;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    // Getters & Setters
}