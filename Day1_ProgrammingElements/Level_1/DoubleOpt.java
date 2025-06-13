package Day1_ProgrammingElements.Level_1;

import java.util.Scanner;

public class DoubleOpt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value for 'a' (double): ");
        double a = scanner.nextDouble();

        System.out.print("Enter the value for 'b' (double): ");
        double b = scanner.nextDouble();

        System.out.print("Enter the value for 'c' (double): ");
        double c = scanner.nextDouble();

        // Operation 1: a + b * c
        double result1 = a + b * c;

        // Operation 2: a * b + c
        double result2 = a * b + c;

        // Operation 3: c + a / b
        double result3 = c + a / b;


        // Operation 4: a % b + c
        double result4 = a % b + c;


        System.out.println("\n--- Results of Double Operations ---");
        System.out.println("For a = " + a + ", b = " + b + ", c = " + c + "\n");
        System.out.println("a + b * c   = " + result1);
        System.out.println("a * b + c   = " + result2);
        System.out.println("c + a / b   = " + result3);
        System.out.println("a % b + c   = " + result4);

        scanner.close();
    }
}