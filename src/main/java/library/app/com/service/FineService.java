package library.app.com.service;


import library.app.com.repository.model.Fine;
import library.app.com.repository.FineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FineService {

    private final FineRepository repository;

    public FineService(FineRepository repository) {
        this.repository = repository;
    }

    public List<Fine> getAllFines() {
        return repository.findAll();
    }

    public Fine createFine(Fine fine) {
        return repository.save(fine);
    }
}