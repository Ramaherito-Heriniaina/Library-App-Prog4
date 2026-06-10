package library.app.com.service;

import com.librairie.dto.StockDTO;
import library.app.com.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

    public List<Stock> findAll() {
        return stockRepository.findAll();
    }

    public Stock findById(Long id) {
        return stockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stock not found with id: " + id));
    }

    public Stock findByBook(Long bookId) {
        return stockRepository.findByBookId(bookId)
                .orElseThrow(() -> new RuntimeException("Stock not found for book id: " + bookId));
    }

    public List<Stock> findLowStock() {
        return stockRepository.findByQuantityLessThanEqual(0);
    }

    public StockDTO toDTO(Stock stock) {
        return StockDTO.builder()
                .id(stock.getId())
                .quantity(stock.getQuantity())
                .alertThreshold(stock.getAlertThreshold())
                .lastUpdated(stock.getLastUpdated())
                .build();
    }

    public List<StockDTO> findAllDTO() {
        return findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public StockDTO findByIdDTO(Long id) {
        return toDTO(findById(id));
    }
}
