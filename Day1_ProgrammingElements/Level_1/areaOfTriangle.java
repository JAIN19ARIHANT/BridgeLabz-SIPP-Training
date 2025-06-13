package Day1_ProgrammingElements.Level_1;

import java.util.Scanner;

public class areaOfTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the base of the triangle in cm: ");
        double baseCm = sc.nextDouble();

        System.out.print("Enter the height of the triangle in cm: ");
        double heightCm = sc.nextDouble();

        // Calculate area in square centimeters
        double areaSqCm = 0.5 * baseCm * heightCm;

        // Convert area from square centimeters to square inches
        // 1 inch = 2.54 cm
        // 1 sq inch = 2.54 cm * 2.54 cm = 6.4516 sq cm
        double areaSqIn = areaSqCm / 6.4516;

        // Result
        System.out.println("The Area of the triangle in sq in is " + String.format("%.2f", areaSqIn) + " and sq cm is " + String.format("%.2f", areaSqCm));

        sc.close();
    }
}