public interface Rentable {

    String RED = "\u001b[31m";
    String RESET = "\u001b[0m";

    void rent();

    void returnVehicle();

    boolean isRented();
}
