package modals;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseClass{

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private BookingStatus bookingStatus;

    @ManyToMany
    private List<ShowSeat>showSeats;

    @ManyToOne
    private Show show;

    @ManyToOne
    private User user;

    @OneToMany
    private List<Payment>payments;

    private LocalDateTime bookedAt;

    private double Amount;
}
