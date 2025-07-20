package EventHive;

import java.util.ArrayList;

public class Event {
    public String eventName;
    private String date;
    private String venue;

    public ArrayList<Ticket> ticketList = new ArrayList<>();

    public Event(String eventName, String date, String venue) {
        this.eventName = eventName;
        this.date = date;
        this.venue = venue;
    }

    public String getEventName() {
        return eventName;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String newVenue) {
        this.venue = newVenue;
    }

    public String getDate() {
        return date;
    }

    public void printEventDetails() {
        System.out.println("\nEvent : " + eventName + " | Venue : " + venue + " | Date : " + date);
    }

    public void updateTicket(Ticket t, String newVenue) {
        if (!t.getBookedVenue().equals(newVenue)) {
            t.setBookedVenue(newVenue);
            System.out.println("\nTicket updated: New venue is " + newVenue);
            t.displayTicket();
        } else {
            System.out.println("No update needed. Ticket already reflects the current venue.");
        }
    }
}
