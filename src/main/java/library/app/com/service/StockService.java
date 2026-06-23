package library.app.com.service;

import library.app.com.entity.Stock;
import library.app.com.exception.NotFoundException;
import library.app.com.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository repository;

    public List<Stock> getAll(int page, int pageSize) {
        return repository.findAll(PageRequest.of(page, pageSize))
                .stream()
                .map(Stock::from)
                .toList();
    }

    public Stock getById(Long id) {
        return repository.findById(id)
                .map(Stock::from)
                .orElseThrow(() -> new NotFoundException("Stock #" + id + " not found"));
    }

    public Stock createOrUpdate(Stock stock) {
        return Stock.from(repository.save(stock));
    }

    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Stock #" + id + " not found");
        }
        repository.deleteById(id);
    }
}