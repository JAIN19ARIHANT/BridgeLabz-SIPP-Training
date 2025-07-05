interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

abstract class Vehicles implements GPS {
    private int vehicleId;
    private String driverName;
    private int ratePerKm;
    private String currentLocation;

    Vehicles (int vehicleId, String driverName, int ratePerKm, String currentLocation) {
        this.driverName = driverName;
        this.vehicleId = vehicleId;
        this.ratePerKm = ratePerKm;
        this.currentLocation = currentLocation;
    }

    public abstract double calculateFare(double distance);

    public String getVehicleDetails() {
        return "ID : " + vehicleId + "\nDiver Name : " + driverName + "\nRate/KM : ₹ " + ratePerKm;
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }

    public int getVehicleId() { return vehicleId; }
    public String getDriverName() { return driverName; }
    public double getRatePerKm() { return ratePerKm; }

}

class Cars extends Vehicles {
    Cars(int vehicleId, String driverName, int ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 50;
    }
}

class Bikes extends Vehicles {
    Bikes(int vehicleId, String driverName, int ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 10;
    }
}


class Auto extends Vehicles {
    Auto(int vehicleId, String driverName, int ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 25;
    }
}

class FareCalculator {
    public static void displayFare(Vehicles vehicle, double distance) {
        System.out.println("--------- Ride Info ---------");
        System.out.println(vehicle.getVehicleDetails());
        System.out.println("Distance: " + distance + " km");
        System.out.println("Fare: ₹" + vehicle.calculateFare(distance));
        System.out.println("-----------------------------\n");
    }
}


public class RideHailingApplication {
    public static void main(String[] args) {
        Vehicles c = new Cars(1, "SRK", 60, "Mannat");
        Vehicles b = new Bikes(5, "Ajay Devgan", 25, "Vimal Chowk");
        Vehicles a = new Auto(7, "Tiger", 35, "Thane");

        Vehicles[] rides = { c, b, a };

        for (Vehicles v : rides) {
            FareCalculator.displayFare(v, 15);
            v.updateLocation("Airport");
        }
    }
}