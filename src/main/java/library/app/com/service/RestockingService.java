package library.app.com.service;

import java.util.List;
import library.app.com.endpoint.rest.model.JRestocking;
import library.app.com.exception.NotFoundException;
import library.app.com.repository.RestockingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestockingService {

  private final RestockingRepository repository;

  public List<JRestocking> getAll(int page, int pageSize) {
    return repository.findAll(PageRequest.of(page, pageSize)).toList();
  }

  public JRestocking getById(Long id) {
    return repository
        .findById(id)
        .orElseThrow(() -> new NotFoundException("Restocking #" + id + " not found"));
  }
}
