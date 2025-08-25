public class AC implements SmartDevice {
    private final String room;
    public AC(String room) {
        this.room = room;
    }

    @Override
    public void turnOn() {
        System.out.println(GREEN + room + " AC turned ON." + RESET);
    }

    @Override
    public void turnOff() {
        System.out.println(RED + room + " AC turned OFF." + RESET);
    }
}
