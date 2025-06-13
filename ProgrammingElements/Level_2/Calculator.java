import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double a = input.nextDouble(), b = input.nextDouble();
        System.out.println("The addition, subtraction, multiplication, and division value of 2 numbers " + a + " and " + b + " is " + (a+b) + ", " + (a-b) + ", " + (a*b) + ", and " + (a/b));
    }
}