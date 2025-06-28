import java.util.Scanner;

public class CarParking {

    static int parkingLotCapacity = 6;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int currentCapacity = 0;

        while (true) {
            System.out.println("\nEnter 'P' to park a car, 'U' to unpark a car, 'C' to show capacity, and 'E' to exit");
            String input = sc.nextLine();
            if (input.isEmpty()) {
                System.err.println("ERROR: Input cannot be empty.");
                continue;
            }
            char text = Character.toUpperCase(input.charAt(0));

            if (text == 'P') {
                if (currentCapacity < parkingLotCapacity) {
                    currentCapacity++;
                    System.out.println("Car parked.");
                } else {
                    System.err.println("Sorry: Lot is full!");
                }
                System.out.println("Capacity of parking lot left: " + (parkingLotCapacity - currentCapacity)); // Display capacity after park attempt
            } else if (text == 'U') {
                if (currentCapacity > 0) {
                    currentCapacity--;
                    System.out.println("Car unparked.");
                } else {
                    System.err.println("Lot is already empty!");
                }
                System.out.println("Capacity of parking lot left: " + (parkingLotCapacity - currentCapacity)); // Display capacity after unpark attempt
            } else if (text == 'C') {
                System.out.println("Capacity of parking lot left: " + (parkingLotCapacity - currentCapacity));
            } else if (text == 'E') {
                break;
            } else {
                System.err.println("ERROR: Wrong input.");
            }
        }
    }
}