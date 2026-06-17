package library.app.com.repository.model;


import lombok.*;
import library.app.com.repository.enums.ReservationStatus;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {

    private String id;
    private Member member;
    private Book book;

    private LocalDate reservationDate;

    private ReservationStatus status;
}