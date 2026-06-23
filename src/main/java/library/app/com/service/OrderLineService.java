package library.app.com.service;

import library.app.com.entity.OrderLine;
import library.app.com.exception.NotFoundException;
import library.app.com.repository.OrderLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderLineService {

    private final OrderLineRepository repository;

    public List<OrderLine> getAll(int page, int pageSize) {
        return repository.findAll(PageRequest.of(page, pageSize))
                .stream()
                .map(OrderLine::from)
                .toList();
    }

    public OrderLine getById(Long id) {
        return repository.findById(id)
                .map(OrderLine::from)
                .orElseThrow(() -> new NotFoundException("OrderLine #" + id + " not found"));
    }

    public OrderLine createOrUpdate(OrderLine orderLine) {
        return OrderLine.from(repository.save(orderLine));
    }

    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("OrderLine #" + id + " not found");
        }
        repository.deleteById(id);
    }
}