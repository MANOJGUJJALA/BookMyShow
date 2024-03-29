package repository;

import modals.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {

    @Override
    Optional<Ticket> findById(Long id);

    Ticket save(Ticket ticket);
}
