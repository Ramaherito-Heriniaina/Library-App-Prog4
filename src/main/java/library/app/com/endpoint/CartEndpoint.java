package library.app.com.endpoint;


import library.app.com.repository.model.Cart;
import library.app.com.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartEndpoint {

    private final CartService service;

    public CartEndpoint(CartService service) {this.service = service;}

    @GetMapping
    public List<Cart> getAll() {return service.getAllCarts();}


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {service.deleteCart(String.valueOf(id));}
}