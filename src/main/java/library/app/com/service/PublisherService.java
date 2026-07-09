package library.app.com.service;

import java.util.List;
import library.app.com.entity.Publisher;
import library.app.com.exception.NotFoundException;
import library.app.com.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublisherService {

  private final PublisherRepository repository;

  public List<Publisher> getAll(int page, int pageSize) {
    return repository.findAll(PageRequest.of(page, pageSize)).stream()
        .map(Publisher::from)
        .toList();
  }

  public Publisher getById(Long id) {
    return repository
        .findById(id)
        .map(Publisher::from)
        .orElseThrow(() -> new NotFoundException("Publisher #" + id + " not found"));
  }
}
