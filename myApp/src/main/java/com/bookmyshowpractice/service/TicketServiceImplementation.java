package service;


import exception.ShowSeatNotAvailable;
import exception.UserNotFoundException;
import exception.nOTicketFound;
import modals.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ShowRepository;
import repository.ShowSeatRepository;
import repository.TicketRepository;
import repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImplementation implements TicketService{

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    UserRepository userRepository;
    @Autowired
    ShowRepository showRepository;
    @Autowired
    ShowSeatRepository showSeatRepository;
    @Override
    public Ticket bookTicket(Long userId, List<Long> showSeatIds, Long showId) {

        Optional<User> userbooked=userRepository.findById(userId);
        Optional<Show> show=showRepository.findById(showId);

        for(Long showd:showSeatIds){
             ShowSeat showSeat=   showSeatRepository.findById(showd).get();

             if(showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                 showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);

             }
             else{
                 throw new ShowSeatNotAvailable("show seat not available");
             }
            showSeatRepository.save(showSeat);

        }

        boolean paymentDone=getPaymnetStatus();
        double amount=0;
            List<ShowSeat> newShowSeats=new ArrayList<>();
        if(paymentDone){

            for(Long showd:showSeatIds){
                ShowSeat showSeat=showSeatRepository.findById(showd).get();

                showSeat.setShowSeatStatus(ShowSeatStatus.BOOKED);

                amount+=showSeat.getPrice();
                newShowSeats.add(showSeat);

                showSeatRepository.save(showSeat);
            }
        }
        return ticketGenerate(userbooked,show,newShowSeats,amount);
    }

    public Ticket ticketGenerate(Optional<User> user, Optional<Show> show, List<ShowSeat>showSeats, double amount){

        Ticket ticket=new Ticket();

        ticket.setAmount(amount);

        ticket.setUser(user.get());
        ticket.setShowSeats(showSeats);
        ticket.setShow(show.get());
        return ticketRepository.save(ticket);
    }

    public boolean getPaymnetStatus(){
        return  true;
    }

    @Override
    public Ticket cancelTicket(Long ticketId) {

        Optional<Ticket> optionalticket=ticketRepository.findById(ticketId);

        if(optionalticket.isEmpty()){
            throw  new nOTicketFound("invalid ticket");
        }
        Ticket ticket=optionalticket.get();

        for(ShowSeat showd:ticket.getShowSeats()){
            ShowSeat showSeat=showSeatRepository.findById(showd).get();
            showSeat.setShowSeatStatus(ShowSeatStatus.AVAILABLE);

            showSeatRepository.save(showSeat);
        }
        ticketRepository.save(ticket);

        for(Payment p : ticket.getPayments()){
            p.getRefno();
            //send a message to 3rd party with payment ref number for refund
        }

        return ticket;
    }

    @Override
    public Ticket transferTicket(Long ticketId, Long fromUserId, Long toUserId) {

        Optional<Ticket> optionalTicket=ticketRepository.findById(ticketId);

        if(optionalTicket.isEmpty()){
            throw  new nOTicketFound("no tikcet found");
        }

        Optional<User> opfromUser=userRepository.findById(fromUserId);

        Optional<User> optuser=userRepository.findById(toUserId);

        if(opfromUser.isEmpty() || optuser.isEmpty()){
            throw new UserNotFoundException("no user found");
        }

        Ticket ticket=optionalTicket.get();


        User FromUser=opfromUser.get();

        List<Ticket>fromUsertickets=FromUser.getTickets();
        fromUsertickets.remove(ticket);

        FromUser.setTickets(fromUsertickets);
        userRepository.save(FromUser);


        User toUser=optuser.get();
        List<Ticket>toUserTickets=toUser.getTickets();
        toUserTickets.add(ticket);
        toUser.setTickets(toUserTickets);
        userRepository.save(toUser);

        ticket.setUser(toUser);

        return ticketRepository.save(ticket);
    }
}
