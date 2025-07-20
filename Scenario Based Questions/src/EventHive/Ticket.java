package EventHive;

import java.util.UUID;

public class Ticket {
    private String ticketId;
    public Event event;
    private String userName;
    private String bookedVenue;

    public Ticket(Event event, String userName) {
        this.ticketId = UUID.randomUUID().toString().substring(0,8).toUpperCase();
        this.event = event;
        this.userName = userName;
        this.bookedVenue = event.getVenue();
    }

    public String getBookedVenue() {
        return this.bookedVenue;
    }

    public void setBookedVenue(String newVenue) {
        this.bookedVenue = newVenue;
    }

    public void displayTicket() {
        System.out.println("\n--------------- TICKET ---------------");
        System.out.println("Ticket ID     : " + ticketId);
        System.out.println("Name          : " + userName);
        System.out.println("Event         : " + event.eventName);
        System.out.println("Date          : " + event.getDate() );
        System.out.println("Venue         : " + event.getVenue());

    }

}
