import java.util.Scanner;

public class IntOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value for 'a': ");
        int a = scanner.nextInt();

        System.out.print("Enter the value for 'b': ");
        int b = scanner.nextInt();

        System.out.print("Enter the value for 'c': ");
        int c = scanner.nextInt();

        // Operation 1: a + b * c
        int result1 = a + b * c;

        // Operation 2: a * b + c
        int result2 = a * b + c;

        // Operation 3: c + a / b
        int result3;
        if (b == 0) {
            System.out.println("\nWarning: Division by zero avoided for 'c + a / b'. Skipping this calculation.");
            result3 = 0;
        } else {
            result3 = c + a / b;
        }


        // Operation 4: a % b + c
        int result4;
        if (b == 0) {
            System.out.println("Warning: Modulo by zero avoided for 'a % b + c'. Skipping this calculation.");
            result4 = 0;
        } else {
            result4 = a % b + c;
        }


        System.out.println("\n--- Results of Integer Operations ---");
        System.out.println("For a = " + a + ", b = " + b + ", c = " + c + "\n");
        System.out.println("a + b * c   = " + result1);
        System.out.println("a * b + c   = " + result2);
        System.out.println("c + a / b   = " + result3);
        System.out.println("a % b + c   = " + result4);

        scanner.close();
    }
}