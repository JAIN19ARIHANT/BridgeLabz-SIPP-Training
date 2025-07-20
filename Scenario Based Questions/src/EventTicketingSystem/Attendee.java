package EventTicketingSystem;

public class Attendee {
    private String name;
    private int age;
    private String email; // Optional

    // Constructor overloading: one without email
    public Attendee(String name, int age) {
        this.name = name;
        this.age = age;
        this.email = "Not provided";
    }

    // Constructor overloading: one with email
    public Attendee(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Attendee[Name: " + name + ", Age: " + age + ", Email: " + email + "]";
    }
}