package Day1_ProgrammingElements.Level_1;

import java.util.Scanner;

public class DistanceConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the distance in feet: ");

        double distanceInFeet = sc.nextDouble();


        double distanceInYards = distanceInFeet / 3.0;

        double distanceInMiles = distanceInYards / 1760.0;

        System.out.println("The distance in yards is " + String.format("%.3f", distanceInYards) + " while the distance in miles is " + String.format("%.3f", distanceInMiles));

        sc.close();
    }
}