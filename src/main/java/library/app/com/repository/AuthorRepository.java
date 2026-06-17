package library.app.com.repository;


import library.app.com.repository.model.Author;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthorRepository {

    private final List<Author> authors = new ArrayList<>();

    public List<Author> findAll() {
        return authors;
    }

    public void deleteById(Long id) {
        authors.removeIf(author -> author.getId().equals(id));
    }
}