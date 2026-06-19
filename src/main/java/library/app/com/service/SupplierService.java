package library.app.com.service;

import library.app.com.endpoint.rest.model.JSupplier;
import library.app.com.exception.NotFoundException;
import library.app.com.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierService {

    private final SupplierRepository repository;

    public List<JSupplier> getAll(int page, int pageSize) {
        return repository.findAll(PageRequest.of(page, pageSize)).toList();
    }

    public JSupplier getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Supplier #" + id + " not found"));
    }
}
