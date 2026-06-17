package library.app.com.endpoint;


import library.app.com.repository.model.Loan;
import library.app.com.service.LoanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanEndpoint {

    private final LoanService service;

    public LoanEndpoint(LoanService service) {
        this.service = service;
    }

    @GetMapping
    public List<Loan> getAllLoans() {
        return service.getAllLoans();
    }

    @DeleteMapping("/{id}")
    public void deleteLoan(@PathVariable Long id) {
        service.deleteLoan(id);
    }
}