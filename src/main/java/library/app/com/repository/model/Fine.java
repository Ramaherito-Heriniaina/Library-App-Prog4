package library.app.com.repository.model;


import java.time.LocalDate;

public class Fine {

    private Long id;
    private Member member;
    private Double amount;
    private Boolean paid;
    private LocalDate fineDate;

    public Fine() {
    }

    public Fine(Long id,
                Member member,
                Double amount,
                Boolean paid,
                LocalDate fineDate) {
        this.id = id;
        this.member = member;
        this.amount = amount;
        this.paid = paid;
        this.fineDate = fineDate;
    }

    // Getters & Setters
}