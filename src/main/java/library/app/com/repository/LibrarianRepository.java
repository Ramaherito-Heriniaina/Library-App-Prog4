package library.app.com.repository;


import library.app.com.repository.model.Librarian;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibrarianRepository {

    private final List<Librarian> librarians = new ArrayList<>();

    public List<Librarian> findAll() {
        return librarians;
    }

    public void deleteById(Long id) {
        librarians.removeIf(librarian -> librarian.getId().equals(id));
    }
}