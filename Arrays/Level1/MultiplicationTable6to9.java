package Level1;
import java.util.Scanner;
public class MultiplicationTable6to9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        int[] multiplicationResult = new int[10];
        for (int i = 6; i <= 9; i++) {
            multiplicationResult[i] = number * i;
        }
        System.out.println("Multiplication table of " + number + " from 6 to 9:");
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + multiplicationResult[i]);
        }
        sc.close();
    }
}