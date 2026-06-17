package library.app.com.repository;

import library.app.com.repository.model.CartItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CartItemRepository {

    private final List<CartItem> CartItems = new ArrayList<>();

    public List<CartItem> findAll() {
        return CartItems;
    }

    public void deleteById(Long id) {
        CartItems.removeIf(CartItem -> CartItem.getId().equals(id));
    }
}