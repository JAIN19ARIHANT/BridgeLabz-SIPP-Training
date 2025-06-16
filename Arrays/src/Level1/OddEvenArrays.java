package Level1;
import java.util.Scanner;
public class OddEvenArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a natural num: ");
        int num = sc.nextInt();

        if (num <= 0) {
            System.out.println("Error: Please enter a natural num (positive integer).");
            System.exit(0);
        }

        int[] evenNumbers = new int[num / 2 + 1];
        int[] oddNumbers = new int[num / 2 + 1];

        int evenIdx = 0;
        int oddIdx = 0;

        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0) {
                evenNumbers[evenIdx] = i;
                evenIdx++;
            } else {
                oddNumbers[oddIdx] = i;
                oddIdx++;
            }
        }

        System.out.print("Odd nums: [");
        for (int i = 0; i < oddIdx; i++) {
            System.out.print(oddNumbers[i]);
            if (i < oddIdx - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        System.out.print("Even nums: [");
        for (int i = 0; i < evenIdx; i++) {
            System.out.print(evenNumbers[i]);
            if (i < evenIdx - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        sc.close();
    }
}