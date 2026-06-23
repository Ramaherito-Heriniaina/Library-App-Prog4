package library.app.com.service;

import library.app.com.endpoint.rest.model.JCart;
import library.app.com.exception.NotFoundException;
import library.app.com.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository repository;

    public List<JCart> getAll(int page, int pageSize) {
        return repository.findAll(PageRequest.of(page, pageSize)).toList();
    }

    public JCart getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cart #" + id + " not found"));
    }

    public JCart createOrUpdate(JCart cart) {
        return repository.save(cart);
    }

    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Cart #" + id + " not found");
        }
        repository.deleteById(id);
    }
}