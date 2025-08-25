public interface SmartDevice {

    String RESET = "\u001b[0m";
    String RED = "\u001b[31m";
    String GREEN = "\u001b[32m";

    void turnOn();
    void turnOff();
}
