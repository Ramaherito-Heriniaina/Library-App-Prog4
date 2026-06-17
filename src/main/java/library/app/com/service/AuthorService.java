package library.app.com.service;


import library.app.com.repository.model.Author;
import library.app.com.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository repository;

    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    public List<Author> getAllAuthors() {
        return repository.findAll();
    }

    public void deleteAuthor(Long id) { repository.deleteById(id); }
}