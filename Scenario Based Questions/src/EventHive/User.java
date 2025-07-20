package EventHive;

import java.util.ArrayList;

public class User {
    private String userName;
    public ArrayList<Ticket> bookedTicketList = new ArrayList<>();

    User (String userName) {
        this.userName = userName;
    }

    public Ticket bookTicket(Event event) {
        Ticket t = new Ticket(event, this.getName());
        System.out.printf("\nA ticket has been successfully booked for the event \"%s\" by user: %s%n", event.eventName, this.userName);
        bookedTicketList.add(t);
        event.ticketList.add(t);
        return t;
    }

    public String getName(){ return userName; }

    public void showTickets(){
        for(Ticket t : bookedTicketList){
            t.displayTicket();
        }
    }

}
