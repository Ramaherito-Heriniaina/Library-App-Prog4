package library.app.com.service;

import library.app.com.endpoint.rest.model.JAuthor;
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

    public List<JAuthor> getAll(int page, int pageSize) {
        return repository.findAll(PageRequest.of(page, pageSize)).getContent();
    }

    public JAuthor getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Author #" + id + " not found"));
    }

    public JAuthor createOrUpdate(JAuthor author) {
        return repository.save(author);
    }

    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Author #" + id + " not found");
        }
        repository.deleteById(id);
    }
}