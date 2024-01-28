package service;


import modals.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TicketService {

    Ticket bookTicket(Long userId, List<Long> showSeatIds, Long showId);
    Ticket cancelTicket(Long ticketId);
    Ticket transferTicket(Long ticketId, Long fromUserId, Long toUserId);
}
