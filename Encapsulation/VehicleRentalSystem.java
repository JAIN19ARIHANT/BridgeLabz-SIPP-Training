import java.util.*;

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}
abstract class Vehicle implements Insurable {
    private String vehicleNumber;
    private String type;
    protected double rentalRate;
    private String insurancePolicyNumber;

    public Vehicle(String vehicleNumber, String type, double rentalRate, String insurancePolicyNumber) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    public abstract double calculateRentalCost(int days);

    protected String getVehicleNumber() {
        return vehicleNumber;
    }

    protected String getType() {
        return type;
    }

    protected String getMaskedPolicyNumber() {
        return "****" + insurancePolicyNumber.substring(insurancePolicyNumber.length() - 4);
    }
}

class Car extends Vehicle {
    public Car(String vehicleNumber, double rentalRate, String policy) {
        super(vehicleNumber, "Car", rentalRate, policy);
    }

    public double calculateRentalCost(int days) {
        return rentalRate * days + 100;
    }

    public double calculateInsurance() {
        return 0.1 * rentalRate;
    }

    public String getInsuranceDetails() {
        return "Car Insurance: " + getMaskedPolicyNumber();
    }
}

class Bike extends Vehicle {
    public Bike(String vehicleNumber, double rentalRate, String policy) {
        super(vehicleNumber, "Bike", rentalRate, policy);
    }

    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    public double calculateInsurance() {
        return 0.05 * rentalRate;
    }

    public String getInsuranceDetails() {
        return "Bike Insurance: " + getMaskedPolicyNumber();
    }
}

class Truck extends Vehicle {
    public Truck(String vehicleNumber, double rentalRate, String policy) {
        super(vehicleNumber, "Truck", rentalRate, policy);
    }

    public double calculateRentalCost(int days) {
        return rentalRate * days + 200;
    }

    public double calculateInsurance() {
        return 0.15 * rentalRate;
    }

    public String getInsuranceDetails() {
        return "Truck Insurance: " + getMaskedPolicyNumber();
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        List<Vehicle> fleet = new ArrayList<>();
        fleet.add(new Car("UP16CAR001", 1500, "CAR12345678"));
        fleet.add(new Bike("UP16BIKE045", 500, "BIKE98765432"));
        fleet.add(new Truck("UP16TRK009", 3000, "TRK45678901"));

        int days = 5;
        for (Vehicle v : fleet) {
            System.out.println("\nVehicle: " + v.getType() + " (" + v.getVehicleNumber() + ")");
            System.out.println("Rental Cost for " + days + " days: ₹" + v.calculateRentalCost(days));
            System.out.println("Insurance: ₹" + v.calculateInsurance());
            System.out.println(v.getInsuranceDetails());
            System.out.println("-----------------------------------------");
        }
    }
}