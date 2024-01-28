package modals;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Theater extends BaseClass{

    private String name;

    @ManyToOne

    private Region region;
    @OneToMany

    private List<Screen> screesn;
}
