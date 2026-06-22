package library.app.com.service;

import library.app.com.entity.Arrival;
import library.app.com.exception.NotFoundException;
import library.app.com.repository.ArrivalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArrivalService {

    private final ArrivalRepository repository;

    public List<Arrival> getAll(int page, int pageSize) {
        return repository.findAll(PageRequest.of(page, pageSize))
                .stream()
                .map(Arrival::from)
                .toList();
    }

    public Arrival getById(Long id) {
        return repository.findById(id)
                .map(Arrival::from)
                .orElseThrow(() -> new NotFoundException("Arrival #" + id + " not found"));
    }

    public List<Arrival> getByBookId(Long bookId) {
        return repository.findByBookId(bookId)
                .stream()
                .map(Arrival::from)
                .toList();
    }
}
