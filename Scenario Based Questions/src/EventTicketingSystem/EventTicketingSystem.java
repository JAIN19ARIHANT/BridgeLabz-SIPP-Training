package EventTicketingSystem;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EventTicketingSystem {
    // HashMap maps an event name (String) to its booking queue (Queue<Attendee>)
    private static HashMap<String, Queue<Attendee>> eventQueues = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Pre-populate with some events
        eventQueues.put("Rock Concert", new LinkedList<>());
        eventQueues.put("Shakespeare Play", new LinkedList<>());

        int choice;
        do {
            System.out.println("\n--- Event Ticketing System ---");
            System.out.println("1. Book a Ticket");
            System.out.println("2. Check Position in Queue");
            System.out.println("3. View Event Queue");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    bookTicket();
                    break;
                case 2:
                    checkPosition();
                    break;
                case 3:
                    viewQueue();
                    break;
                case 0:
                    System.out.println("Thank you for using the system.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 0);
    }

    private static String selectEvent() {
        System.out.println("Available Events:");
        int i = 1;
        for (String eventName : eventQueues.keySet()) {
            System.out.println(i++ + ". " + eventName);
        }
        System.out.print("Select an event: ");
        int eventChoice = scanner.nextInt();
        scanner.nextLine();

        if (eventChoice > 0 && eventChoice <= eventQueues.size()) {
            return (String) eventQueues.keySet().toArray()[eventChoice - 1];
        }
        return null;
    }

    public static void bookTicket() {
        String eventName = selectEvent();
        if (eventName == null) {
            System.out.println("Invalid event selection.");
            return;
        }

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Do you want to provide an email? (yes/no): ");
        String emailChoice = scanner.nextLine();

        Attendee attendee;
        if (emailChoice.equalsIgnoreCase("yes")) {
            System.out.print("Enter your email: ");
            String email = scanner.nextLine();
            attendee = new Attendee(name, age, email); // Uses constructor with email
        } else {
            attendee = new Attendee(name, age); // Uses constructor without email
        }

        eventQueues.get(eventName).add(attendee);
        System.out.println("\n" + name + ", you have been added to the queue for " + eventName + ".");
    }

    public static void checkPosition() {
        String eventName = selectEvent();
        if (eventName == null) {
            System.out.println("Invalid event selection.");
            return;
        }

        System.out.print("Enter the name to check position for: ");
        String name = scanner.nextLine();

        Queue<Attendee> queue = eventQueues.get(eventName);
        int position = 1;
        boolean found = false;

        // Linear Search on the queue
        for (Attendee attendee : queue) {
            if (attendee.getName().equalsIgnoreCase(name)) {
                System.out.println("\n" + name + " is at position " + position + " in the queue for " + eventName + ".");
                found = true;
                break;
            }
            position++;
        }

        if (!found) {
            System.out.println("\nAttendee '" + name + "' not found in the queue for " + eventName + ".");
        }
    }

    public static void viewQueue() {
        String eventName = selectEvent();
        if (eventName == null) {
            System.out.println("Invalid event selection.");
            return;
        }

        Queue<Attendee> queue = eventQueues.get(eventName);
        System.out.println("\n--- Current Queue for " + eventName + " ---");
        if (queue.isEmpty()) {
            System.out.println("The queue is currently empty.");
        } else {
            int pos = 1;
            for (Attendee attendee : queue) {
                System.out.println(pos++ + ". " + attendee);
            }
        }
    }
}