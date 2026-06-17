package library.app.com.endpoint;


import library.app.com.repository.model.BookPromotion;
import library.app.com.service.BookPromotionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book-promotions")
public class BookPromotionEndpoint {

    private final BookPromotionService service;

    public BookPromotionEndpoint(BookPromotionService service) {this.service = service;}

    @GetMapping
    public List<BookPromotion> getAll() {return service.getAllBookPromotions();}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {service.deleteBookPromotion(String.valueOf(id));}
}