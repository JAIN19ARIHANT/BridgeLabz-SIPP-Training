package Level1;

import java.util.Scanner;

public class ArraySum {

    public static void main(String[] args) {
        double[] nums = new double[10];
        double total = 0.0;
        int idx = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Numbers");

        while (true) {
            System.out.print("Enter " + (idx + 1) + "st number : ");
            double userEntry = sc.nextDouble();

            if (userEntry <= 0) {
                System.out.println("Zero or negative number entered. Stopping input");
                break;
            }

            if (idx == 10) {
                System.out.println("Maximum limit reached. Stopping input");
                break;
            }

            nums[idx] = userEntry;
            idx++;
        }

        System.out.println("\n--- Numbers Entered ---");
        for (int i = 0; i < idx; i++) {
            System.out.println(nums[i]);
            total += nums[i];
        }

        System.out.println("\n--- Calculation Summary ---");
        System.out.println("Total sum of the nums: " + total);

        sc.close();
    }
}