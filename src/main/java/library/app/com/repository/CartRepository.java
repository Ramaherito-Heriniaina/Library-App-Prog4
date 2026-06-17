package library.app.com.repository;

import library.app.com.repository.model.Cart;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CartRepository {

    private final List<Cart> Carts = new ArrayList<>();

    public List<Cart> findAll() {
        return Carts;
    }

    public void deleteById(Long id) {
        Carts.removeIf(Cart -> Cart.getId().equals(id));
    }
}