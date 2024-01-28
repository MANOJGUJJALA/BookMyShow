package modals;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class User extends BaseClass{

    private String email;
    private String password;
    private String name;

    private List<Ticket>tickets;
}
