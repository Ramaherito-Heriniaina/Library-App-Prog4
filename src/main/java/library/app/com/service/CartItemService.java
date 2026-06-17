package library.app.com.service;


import library.app.com.repository.model.CartItem;
import library.app.com.repository.CartItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {

    private final CartItemRepository repository;

    public CartItemService(CartItemRepository repository) {this.repository = repository;}

    public List<CartItem> getAllCartItems() {return repository.findAll();}

    public void deleteCartItem(String id) {repository.deleteById(Long.valueOf(id));}
}