package repository;

import modals.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ShowRepository extends JpaRepository<Show,Long> {


   Show findById(Show id);

    Show save(Show show);
}
