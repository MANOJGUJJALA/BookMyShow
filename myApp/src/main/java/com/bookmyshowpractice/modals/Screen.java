package modals;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Screen extends BaseClass{

    private String name;

    @ManyToOne

    private Theater theater;

    @OneToMany
    private List<Seat>seats;


    @Enumerated(EnumType.ORDINAL)
    @ElementCollection

    private List<Feature>features;

}
