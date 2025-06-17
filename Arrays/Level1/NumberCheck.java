package Level1;

import java.util.Scanner;
public class NumberCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];

        System.out.println("Enter 5 numbers : ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        for (int n : arr) {
            if (n > 0) {
                if (n % 2 == 0)
                    System.out.println(n + " is a positive even number");
                else
                    System.out.println(n + " is a positive odd number");
            }

            else if (n < 0)
                System.out.println(n + " is a negative number");

            else
                System.out.println("ZERO");
        }
    }
}
