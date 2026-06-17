package library.app.com.service;

import library.app.com.repository.model.Promotion;
import library.app.com.repository.PromotionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionService {

    private final PromotionRepository repository;

    public PromotionService(PromotionRepository repository) {
        this.repository = repository;
    }

    public List<Promotion> getAllPromotions() {
        return repository.findAll();
    }

    public void deletePromotion(String id) {
        repository.deleteById(Long.valueOf(id));
    }
}