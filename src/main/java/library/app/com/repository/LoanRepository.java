package library.app.com.repository;

import library.app.com.repository.model.Loan;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LoanRepository {

    private final List<Loan> loans = new ArrayList<>();

    public List<Loan> findAll() {
        return loans;
    }

    public Loan save(Loan loan) {
        loans.add(loan);
        return loan;
    }
}