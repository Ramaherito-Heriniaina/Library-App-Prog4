package library.app.com.endpoint.rest.controller.health;

import library.app.com.endpoint.rest.model.JPromotion;
import library.app.com.service.PromotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/promotions")
@RequiredArgsConstructor
public class PromotionController {

    private final PromotionService service;

    @GetMapping
    public List<JPromotion> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int pageSize) {
        return service.getAll(page, pageSize);
    }

    @GetMapping("/{id}")
    public JPromotion getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public JPromotion create(@RequestBody JPromotion promotion) {
        return service.createOrUpdate(promotion);
    }

    @PutMapping("/{id}")
    public JPromotion update(@PathVariable Long id, @RequestBody JPromotion promotion) {
        promotion.setId(id); // Assure la cohérence de l'ID
        return service.createOrUpdate(promotion);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}