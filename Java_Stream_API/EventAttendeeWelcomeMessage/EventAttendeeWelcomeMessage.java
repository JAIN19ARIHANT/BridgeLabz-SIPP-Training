import java.util.*;
public class EventAttendeeWelcomeMessage {
    public static void main(String[] args) {
        List<String> attendees = Arrays.asList("Alice", "Bob", "Charlie", "Denise");
        attendees.forEach(a -> System.out.println("Welcome, " + a + "!"));
    }
}
