package EventHive;

public class EventHiveMain {
    public static void main(String[] args) {
        // 👩‍💼 Create an Admin
        Admin admin = new Admin("MEA");

        // 🗓️ Add Events
        admin.addEvent("The Raisina Dialogue", "19-03-2025", "New Delhi");
        admin.addEvent("MEA Presser", "06-05-2025", "New Delhi");

        // 📋 Show All Events
        System.out.println("\n------------------ Available Events -------------------");
        admin.showEvents();

        // 👨‍🎓 Create a User
        User user = new User("Arihant");

        // 🔍 Find Event
        String eventNameToFind = "The Raisina Dialogue";
        Event event = admin.findEvent(eventNameToFind);

        // 🎟️ Book Ticket
        if (event != null) {
            Ticket ticket = user.bookTicket(event);
        } else {
            System.out.println("Event not found.");
            return;
        }

        // 🎫 Show User Tickets
        user.showTickets();

        // 🏛️ Modify Event Venue by Admin
        admin.modifyEvent(event, "Raisina Hill, New Delhi");

        // 🚫 Remove an Event
        Event presserEvent = admin.findEvent("MEA Presser");
        admin.removeEvent(presserEvent);

        // 📋 Show Events After Removal
        System.out.println("\n--- Events After Removal ---");
        admin.showEvents();
    }
}