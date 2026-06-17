package library.app.com.endpoint;


import library.app.com.repository.model.Promotion;
import library.app.com.service.PromotionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/promotions")
public class PromotionEndpoint {

    private final PromotionService service;

    public PromotionEndpoint(PromotionService service) {this.service = service;}

    @GetMapping
    public List<Promotion> getAll() {return service.getAllPromotions();}


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {service.deletePromotion(String.valueOf(id));}
}