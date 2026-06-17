package library.app.com.service;


import library.app.com.repository.model.BookPromotion;
import library.app.com.repository.BookPromotionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookPromotionService {

    private final BookPromotionRepository repository;

    public BookPromotionService(BookPromotionRepository repository) {this.repository = repository;}

    public List<BookPromotion> getAllBookPromotions() {return repository.findAll();}

    public void deleteBookPromotion(String id) {repository.deleteById(Long.valueOf(id));}
}