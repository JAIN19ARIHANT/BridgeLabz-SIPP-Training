public class RestaurantSystem {
    public static void main(String[] args) {
        Chef chef = new Chef("Aeihant", 101, "Indian Cuisine");
        Waiter waiter = new Waiter("Arjun", 202, "Garden Lounge");

        chef.performDuties();
        waiter.performDuties();
    }
}

// Superclass
class Person {
    String name;
    int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

// Interface
interface Worker {
    void performDuties();
}

// Subclass 1 implementing the interface
class Chef extends Person implements Worker {
    String specialty;

    public Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    public void performDuties() {
        System.out.println("Chef: " + name + ", ID: " + id);
        System.out.println("Specialty: " + specialty);
        System.out.println("Duties: Prepare delicious meals and manage the kitchen.\n");
    }
}

// Subclass 2 implementing the interface
class Waiter extends Person implements Worker {
    String sectionAssigned;

    public Waiter(String name, int id, String sectionAssigned) {
        super(name, id);
        this.sectionAssigned = sectionAssigned;
    }

    public void performDuties() {
        System.out.println("Waiter: " + name + ", ID: " + id);
        System.out.println("Section: " + sectionAssigned);
        System.out.println("Duties: Take orders, serve food, and ensure customer satisfaction.\n");
    }
}