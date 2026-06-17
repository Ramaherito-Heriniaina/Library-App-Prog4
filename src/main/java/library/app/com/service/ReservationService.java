package library.app.com.service;


import library.app.com.repository.model.Reservation;
import library.app.com.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository repository;

    public ReservationService(ReservationRepository repository) {
        this.repository = repository;
    }

    public List<Reservation> getAllReservations() {
        return repository.findAll();
    }

    public void deleteReservation(Long id) { repository.deleteById(id); }
}