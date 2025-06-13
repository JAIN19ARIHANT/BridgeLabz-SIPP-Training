package Day1_ProgrammingElements.Level_1;

import java.util.Scanner;

public class QuotientRemainder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number (dividend): ");
        int number1 = scanner.nextInt();

        System.out.print("Enter the second number (divisor): ");
        int number2 = scanner.nextInt();

        if (number2 == 0) {
            System.out.println("Error: Cannot divide by zero. Please enter a non-zero second number.");
        } else {
            int quotient = number1 / number2;

            int remainder = number1 % number2;

            System.out.println("The Quotient is " + quotient +
                    " and Reminder is " + remainder +
                    " of two numbers " + number1 + " and " + number2 + ".");
        }

        scanner.close();
    }
}