package library.app.com.service;

import com.librairie.dto.SaleDTO;
import com.librairie.dto.SaleItemDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SaleService {

    private final SaleRepository saleRepository;

    public List<Sale> findAll() {
        return saleRepository.findAll();
    }

    public Sale findById(Long id) {
        return saleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sale not found with id: " + id));
    }

    public List<Sale> findByCustomer(Long customerId) {
        return saleRepository.findByCustomerId(customerId);
    }

    public List<Sale> findByStatus(Sale.SaleStatus status) {
        return saleRepository.findByStatus(status);
    }

    public List<Sale> findByDateRange(LocalDateTime from, LocalDateTime to) {
        return saleRepository.findBySaleDateBetween(from, to);
    }

    public SaleDTO toDTO(Sale sale) {
        return SaleDTO.builder()
                .id(sale.getId())
                .saleDate(sale.getSaleDate())
                .totalAmount(sale.getTotalAmount())
                .status(sale.getStatus().name())
                .customer(sale.getCustomer() != null ?
                    CustomerService.toDTO(sale.getCustomer()) : null)
                .saleItems(sale.getSaleItems() != null ?
                    sale.getSaleItems().stream().map(item ->
                        SaleItemDTO.builder()
                            .id(item.getId())
                            .quantity(item.getQuantity())
                            .unitPrice(item.getUnitPrice())
                            .build()
                    ).collect(Collectors.toList()) : null)
                .build();
    }

    public List<SaleDTO> findAllDTO() {
        return findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public SaleDTO findByIdDTO(Long id) {
        return toDTO(findById(id));
    }
}
