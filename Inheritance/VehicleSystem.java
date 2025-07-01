public class VehicleSystem {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle("BE 6e", 310);
        PetrolVehicle pv = new PetrolVehicle("Harrier", 220);

        ev.charge();
        pv.refuel();
    }
}

// Superclass
class Vehicle {
    String model;
    int maxSpeed;

    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }
}

// Interface
interface Refuelable {
    void refuel();
}

// Subclass 1
class ElectricVehicle extends Vehicle {

    public ElectricVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }

    public void charge() {
        System.out.println("Electric Vehicle: " + model + ", Max Speed: " + maxSpeed + " km/h");
        System.out.println("Action: Charging battery at EV station.\n");
    }
}

// Subclass 2 implementing interface
class PetrolVehicle extends Vehicle implements Refuelable {

    public PetrolVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }

    public void refuel() {
        System.out.println("Petrol Vehicle: " + model + ", Max Speed: " + maxSpeed + " km/h");
        System.out.println("Action: Refueling at petrol pump.\n");
    }
}