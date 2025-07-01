public class VehicleAndTransportSystem {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
                new Car(240, "Electric", 5),
                new Truck(140, "Diesel", 15),
                new Motorcycle(120, "Petrol", 22)
        };

        for (Vehicle v : vehicles) {
            System.out.println("----- Vehicle Info -----");
            v.displayInfo();
            System.out.println();
        }
    }

}

class Vehicle {
    int maxSpeed;
    String fuelType;

    Vehicle (int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    void displayInfo() {
        System.out.println("Max speed : " + maxSpeed + "Kmph");
        System.out.println("Fuel Type : " + fuelType);
    }
}

class Car extends Vehicle {
    int seatCapacity;

    Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Sitting Capacity " + seatCapacity);
    }
}

class Truck extends Vehicle {
    double loadCapacity;

    Truck(int maxSpeed, String fuelType, double loadCapacity) {
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Load Capacity: " + loadCapacity + " tons");
    }
}

class Motorcycle extends Vehicle {
    double milage;

    Motorcycle(int maxSpeed, String fuelType, double milage) {
        super(maxSpeed, fuelType);
        this.milage = milage;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Milage " + milage + "kmpl");
    }
}
