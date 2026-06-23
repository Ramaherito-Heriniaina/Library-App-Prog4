package library.app.com.service;

import library.app.com.endpoint.rest.model.JRestocking;
import library.app.com.exception.NotFoundException;
import library.app.com.repository.RestockingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestockingService {

    private final RestockingRepository repository;

    public List<JRestocking> getAll(int page, int pageSize) {
        return repository.findAll(PageRequest.of(page, pageSize)).toList();
    }

    public JRestocking getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Restocking #" + id + " not found"));
    }

    public JRestocking createOrUpdate(JRestocking restocking) {
        return repository.save(restocking);
    }

    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Restocking #" + id + " not found");
        }
        repository.deleteById(id);
    }
}