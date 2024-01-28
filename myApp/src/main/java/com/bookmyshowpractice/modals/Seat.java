package modals;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseClass{

    private int seatNumber;
    private int colNumber;
    private int rowNumber;


    @ManyToOne
    private SeatType seattype;
}
