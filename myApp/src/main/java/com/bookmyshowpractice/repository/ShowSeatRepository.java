package repository;

import modals.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat,Long> {

    Optional<ShowSeat>findById(ShowSeat id);

    ShowSeat save(ShowSeat showSeat);

}
