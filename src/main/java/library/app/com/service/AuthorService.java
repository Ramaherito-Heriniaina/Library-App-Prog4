package library.app.com.service;

import library.app.com.entity.Author;
import library.app.com.exception.NotFoundException;
import library.app.com.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository repository;

    public List<Author> getAll(int page, int pageSize) {
        return repository.findAll(PageRequest.of(page, pageSize))
                .stream()
                .map(Author::from)
                .toList();
    }

    public Author getById(Long id) {
        return repository.findById(id)
                .map(Author::from)
                .orElseThrow(() -> new NotFoundException("Author #" + id + " not found"));
    }
}
