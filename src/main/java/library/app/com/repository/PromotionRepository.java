package library.app.com.repository;

import library.app.com.repository.model.Promotion;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PromotionRepository {

    private final List<Promotion> Promotions = new ArrayList<>();

    public List<Promotion> findAll() {
        return Promotions;
    }

    public void deleteById(Long id) {
        Promotions.removeIf(Promotion -> Promotion.getId().equals(id));
    }
}