package library.app.com.endpoint;


import library.app.com.repository.model.CartItem;
import library.app.com.service.CartItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart-items")
public class CartItemEndpoint {

    private final CartItemService service;

    public CartItemEndpoint(CartItemService service) {this.service = service;}

    @GetMapping
    public List<CartItem> getAll() {return service.getAllCartItems();}


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {service.deleteCartItem(String.valueOf(id));}
}