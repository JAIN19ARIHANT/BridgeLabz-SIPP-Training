public class TV implements SmartDevice {
    private final String brand;
    private final String model;

    public TV(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    @Override
    public void turnOn() {
        System.out.printf(GREEN + "TV : %s %s is now ON.\n" + RESET,brand, model);
    }

    @Override
    public void turnOff() {
        System.out.printf(RED + "TV : %s %s is now OFF.\n" + RESET,brand, model);
    }
}
