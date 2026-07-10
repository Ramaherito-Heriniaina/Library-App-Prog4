package library.app.com.service;

import java.util.List;
import library.app.com.entity.OrderLine;
import library.app.com.exception.NotFoundException;
import library.app.com.repository.OrderLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderLineService {

  private final OrderLineRepository repository;

  public List<OrderLine> getAll(int page, int pageSize) {
    return repository.findAll(PageRequest.of(page, pageSize)).stream()
        .map(OrderLine::from)
        .toList();
  }

  public OrderLine getById(Long id) {
    return repository
        .findById(id)
        .map(OrderLine::from)
        .orElseThrow(() -> new NotFoundException("OrderLine #" + id + " not found"));
  }
}
