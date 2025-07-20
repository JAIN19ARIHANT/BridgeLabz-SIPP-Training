package EventHive;

import java.util.ArrayList;

public class Admin implements EventManager {
    private String adminName;
    private ArrayList<Event> events = new ArrayList<>();

    Admin(String name) { this.adminName = name; }

    @Override
    public void modifyEvent(Event e, String newVenue) {
        System.out.println("\nThe venue for '" + e.getEventName() + "' has been updated to " + newVenue + ".");
        e.setVenue(newVenue);

        for (Ticket t : e.ticketList) {
            e.updateTicket(t, newVenue);
        }
    }

    @Override
    public void removeEvent(Event e) {
        System.out.println("\nEvent " + e.getEventName() + " removed by Admin : " + adminName);
        events.remove(e);
    }

    public void addEvent(String eventName, String date, String venue){
        Event e = new Event(eventName, date, venue);
        events.add(e);

    }

    public Event findEvent(String name){
        for(Event e : events){
            if(e.eventName.contains(name)){
                return e;
            }
        }
        return null;
    }

    public void showEvents(){
        for (Event e : events){
            e.printEventDetails();
        }
    }
}
