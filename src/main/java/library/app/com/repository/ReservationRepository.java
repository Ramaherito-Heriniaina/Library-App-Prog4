package library.app.com.repository;

import library.app.com.repository.model.Reservation;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ReservationRepository {

    private final List<Reservation> reservations = new ArrayList<>();

    public List<Reservation> findAll() {
        return reservations;
    }

    public Reservation save(Reservation reservation) {
        reservations.add(reservation);
        return reservation;
    }
}