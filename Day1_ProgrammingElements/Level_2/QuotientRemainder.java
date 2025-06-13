import java.util.Scanner;
public class QuotientRemainder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt(), b = input.nextInt();
        System.out.println("The Quotient is " + (a/b) + " and Reminder is " + (a%b) + " of two number " + a + " and " + b);
    }
}