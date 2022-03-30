package ro.fasttrackit.curs22homework.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ro.fasttrackit.curs22homework.model.Reservation;
import ro.fasttrackit.curs22homework.repository.ReservationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    private static final Logger log = LoggerFactory.getLogger(ReservationService.class);
    private final ReservationRepository repository;

    public ReservationService(ReservationRepository repository) {
        this.repository = repository;
    }

    public List<Reservation> getAll() {
        return repository.findAll();
    }

    public Optional<Reservation> getReservation(Integer id) {
        return repository.findById(id);
    }

    public Reservation add(Reservation reservation) {
        return repository.save(reservation);
    }

    public Optional<Reservation> delete(int id) {
        log.info("Deleting reservation with id {}", id);
        Optional<Reservation> toDelete = repository.findById(id);
        toDelete.ifPresent(repository::delete);
        return toDelete;
    }

    public Reservation replace(int id, Reservation reservation) {
        reservation.setId(id);
        return repository.save(reservation);
    }
}
