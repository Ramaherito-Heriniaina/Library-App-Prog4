package library.app.com.service;

import java.util.List;
import library.app.com.endpoint.rest.model.JPromotion;
import library.app.com.exception.NotFoundException;
import library.app.com.repository.PromotionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PromotionService {

  private final PromotionRepository repository;

  public List<JPromotion> getAll(int page, int pageSize) {
    return repository.findAll(PageRequest.of(page, pageSize)).toList();
  }

  public JPromotion getById(Long id) {
    return repository
        .findById(id)
        .orElseThrow(() -> new NotFoundException("Promotion #" + id + " not found"));
  }
}
