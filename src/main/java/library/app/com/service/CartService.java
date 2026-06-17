package library.app.com.service;


import library.app.com.repository.model.Cart;
import library.app.com.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository repository;

    public CartService(CartRepository repository) {this.repository = repository;}

    public List<Cart> getAllCarts() {return repository.findAll();}

    public void deleteCart(String id) {repository.deleteById(Long.valueOf(id));}
}