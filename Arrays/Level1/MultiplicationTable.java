package Level1;

import java.util.Scanner;
public class MultiplicationTable {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer to see its multiplication table: ");
        int number = sc.nextInt();

        int[] multiplicationTable = new int[11];

        for (int i = 1; i <= 10; i++) {
            multiplicationTable[i] = number * i;
        }

        System.out.println("\nMultiplication Table of " + number + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " * " + i + " = " + multiplicationTable[i]);
        }

        sc.close();
    }
}
