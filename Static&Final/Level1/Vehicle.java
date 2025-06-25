package Static&Final.Level1;

public class Vehicle {

    private static double registrationFee = 500.00;
    private final String registrationNumber;
    private String ownerName;
    private String vehicleType;

    public static void main(String[] args) {
        System.out.println("Welcome to the Vehicle Registration System!");

        Vehicle car1 = new Vehicle("DL12AB1234", "Arihant Jain", "Car");
        Vehicle bike1 = new Vehicle("UP78CD5678", "Suryansh", "Motorcycle");
        Vehicle truck1 = new Vehicle("HR01EF9012", "Arun Rajpoot", "Truck");

        if (car1 instanceof Vehicle) {
            System.out.println("\nChecking car1 type using instanceof:");
            car1.displayRegistrationDetails();
        }

        if (bike1 instanceof Vehicle) {
            bike1.displayRegistrationDetails();
        }
        if (truck1 instanceof Vehicle) {
            truck1.displayRegistrationDetails();
        }

        System.out.println("\nInitial Registration Fee: ₹" + String.format("%.2f", Vehicle.registrationFee));
        Vehicle.updateRegistrationFee(750.00);
        System.out.println("Updated Registration Fee: ₹" + String.format("%.2f", Vehicle.registrationFee));

        System.out.println("\n--- Vehicle Details after Fee Update ---");
        car1.displayRegistrationDetails();
        bike1.displayRegistrationDetails();
        truck1.displayRegistrationDetails();

        Object randomObject = new Integer(12345);
        if (randomObject instanceof Vehicle) {
            System.out.println("\nrandomObject is an instance of Vehicle.");
        } else {
            System.out.println("\nrandomObject is NOT an instance of Vehicle.");
        }
    }

    public Vehicle(String registrationNumber, String ownerName, String vehicleType) {
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public static void updateRegistrationFee(double newFee) {
        if (newFee >= 0) {
            registrationFee = newFee;
            System.out.println("Registration fee updated to: ₹" + String.format("%.2f", registrationFee));
        } else {
            System.out.println("Registration fee cannot be negative.");
        }
    }

    public void displayRegistrationDetails() {
        System.out.println("\n--- Vehicle Registration Details ---");
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: ₹" + String.format("%.2f", registrationFee));
        System.out.println("--------------------------------------");
    }
}
