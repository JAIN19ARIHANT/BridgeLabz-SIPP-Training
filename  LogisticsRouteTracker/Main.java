public class Main {
    public static void main(String[] args) {
        Driver d = new Driver("101","Bhaskar");

        d.addCheckpoint(new DeliveryCheckpoint("C1-1", "Dark Store A", 30, 60, 70));
        d.addCheckpoint(new DeliveryCheckpoint("C1-2", "Dark Store B", 10, 15, 10));
        d.addCheckpoint(new FuelCheckpoint("C2", "Petrol Pump A", 2, 5, 5));
        d.addCheckpoint(new DeliveryCheckpoint("C3", "Destination A", 7, 20, 25));
        d.addCheckpoint(new RestCheckpoint("C4", "Lounge A", 4, 60, 95));
        d.addCheckpoint(new DeliveryCheckpoint("C5", "Destination B", 12, 30, 20));

        d.printSummary();
    }
}