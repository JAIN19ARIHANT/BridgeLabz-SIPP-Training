import java.util.Scanner;
public class Calculator
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number : ");
        float num1 = sc.nextFloat();
        System.out.print("Enter second number : ");
        float num2 = sc.nextFloat();

        float sum = num1 + num2;
        float difference = num1 - num2;
        float product = num1 * num2;
        float division = num1/num2;

        // Result
        System.out.print("The addition, subtraction, multiplication, and division value of 2 numbers "+ num1 +" and " + num2 +" is " +sum + ", "+ difference + ", " + product + " and " + division);

        sc.close();
    }
}