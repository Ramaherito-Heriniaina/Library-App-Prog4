package library.app.com.service;

import library.app.com.endpoint.rest.model.JStock;
import library.app.com.entity.Stock;
import library.app.com.exception.NotFoundException;
import library.app.com.repository.StockMovementRepository;
import library.app.com.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository repository;
    private final StockMovementRepository stockMovementRepository;


    public List<Stock> getAll(int page, int pageSize) {
        return repository.findAll(PageRequest.of(page, pageSize))
                .stream()
                .map(this::toStockWithComputedQuantity)
                .toList();
    }

    public Stock getById(Long id) {
        JStock stock = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Stock #" + id + " not found"));
        return toStockWithComputedQuantity(stock);
    }

    /**
     * Stock d'un livre précis (par bookId), quantité calculée à la volée
     * depuis StockMovement (IN - OUT).
     */
    public Stock getStockByBookId(Long bookId) {
        JStock stock = repository.findByBookId(bookId)
                .orElseThrow(() -> new NotFoundException("Stock for Book #" + bookId + " not found"));
        return toStockWithComputedQuantity(stock);
    }

    /**
     * Stock de tous les livres, quantité calculée à la volée pour chacun.
     */
    public List<Stock> getAllStocks() {
        return repository.findAll()
                .stream()
                .map(this::toStockWithComputedQuantity)
                .toList();
    }

    // ===== Helper interne =====

    private Stock toStockWithComputedQuantity(JStock stock) {
        Long bookId = stock.getBook() != null ? stock.getBook().getId() : null;
        int computedQuantity = bookId != null
                ? stockMovementRepository.computeStockQuantity(bookId)
                : 0;
        return Stock.from(stock, computedQuantity);
    }

    // Aucune méthode create/update n'existe ici volontairement :
    // la quantité ne peut JAMAIS être écrite directement,
    // elle ne change qu'en ajoutant un JStockMovement (IN ou OUT).
}
