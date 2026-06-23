package library.app.com.endpoint.rest.controller.health;

import library.app.com.endpoint.rest.model.JCart;
import library.app.com.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
@RequiredArgsConstructor
public class CartController {

    private final CartService service;

    @GetMapping
    public List<JCart> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int pageSize) {
        return service.getAll(page, pageSize);
    }

    @GetMapping("/{id}")
    public JCart getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public JCart create(@RequestBody JCart cart) {
        return service.createOrUpdate(cart);
    }

    @PutMapping("/{id}")
    public JCart update(@PathVariable Long id, @RequestBody JCart cart) {
        cart.setId(id);
        return service.createOrUpdate(cart);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}