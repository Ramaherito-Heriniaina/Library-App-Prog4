package library.app.com.endpoint;


import library.app.com.repository.model.Fine;
import library.app.com.service.FineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fines")
public class FineEndpoint {

    private final FineService service;

    public FineEndpoint(FineService service) {
        this.service = service;
    }

    @GetMapping
    public List<Fine> getAllFines() {
        return service.getAllFines();
    }

    @PostMapping
    public Fine createFine(@RequestBody Fine fine) {
        return service.createFine(fine);
    }

}