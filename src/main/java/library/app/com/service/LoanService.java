package library.app.com.service;


import library.app.com.repository.model.Loan;
import library.app.com.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    private final LoanRepository repository;

    public LoanService(LoanRepository repository) {
        this.repository = repository;
    }

    public List<Loan> getAllLoans() {
        return repository.findAll();
    }

    public Loan createLoan(Loan loan) {
        return repository.save(loan);
    }
}