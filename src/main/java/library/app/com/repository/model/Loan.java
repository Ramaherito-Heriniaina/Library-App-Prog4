package library.app.com.repository.model;


import lombok.*;
import library.app.com.repository.enums.LoanStatus;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Loan {
    private String id;
    private Member member;
    private Book book;

    private LocalDate loanDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    private LoanStatus status;
}