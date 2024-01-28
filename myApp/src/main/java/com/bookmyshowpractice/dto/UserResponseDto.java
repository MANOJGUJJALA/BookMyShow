package dto;

import lombok.Getter;
import lombok.Setter;
import modals.Ticket;

import java.util.List;

@Getter
@Setter
public class UserResponseDto {

    private int id;
    private String email;
    private String name;
    private int responseCode;
    private String responseMessage;
    private List<Ticket> tickets;
}
