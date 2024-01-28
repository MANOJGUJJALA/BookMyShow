package modals;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Region extends BaseClass{

    private String name;

    @OneToMany

    private List<Theater> teaters;

}
