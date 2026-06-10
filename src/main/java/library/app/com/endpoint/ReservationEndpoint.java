package library.app.com.endpoint;


import library.app.com.repository.model.Reservation;
import library.app.com.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationEndpoint {

    private final ReservationService service;

    public ReservationEndpoint(ReservationService service) {
        this.service = service;
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return service.getAllReservations();
    }

    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return service.createReservation(reservation);
    }

}