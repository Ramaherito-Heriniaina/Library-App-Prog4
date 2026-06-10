package library.app.com.service;


import library.app.com.repository.model.Librarian;
import library.app.com.repository.LibrarianRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibrarianService {

    private final LibrarianRepository repository;

    public LibrarianService(LibrarianRepository repository) {
        this.repository = repository;
    }

    public List<Librarian> getAllLibrarians() {
        return repository.findAll();
    }

    public Librarian createLibrarian(Librarian librarian) {
        return repository.save(librarian);
    }
}