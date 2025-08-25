public class Light implements SmartDevice {
    private final String location;
    public Light(String location) {
        this.location = location;
    }

    @Override
    public void turnOn() {
        System.out.println(GREEN + location + " light turned ON." + RESET);
    }

    @Override
    public void turnOff() {
        System.out.println(RED + location + " light turned OFF." + RESET);
    }
}