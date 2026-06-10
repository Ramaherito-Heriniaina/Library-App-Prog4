package library.app.com.repository.model;


import java.time.LocalDate;

public class Reservation {

    private Long id;
    private Book book;
    private Member member;

    private LocalDate reservationDate;
    private String status;

    public Reservation() {
    }

    public Reservation(Long id,
                       Book book,
                       Member member,
                       LocalDate reservationDate,
                       String status) {
        this.id = id;
        this.book = book;
        this.member = member;
        this.reservationDate = reservationDate;
        this.status = status;
    }

    // Getters & Setters
}