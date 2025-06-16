package Level1;
import java.util.Scanner;

public class FactorFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number to find its factors: ");
        int num = sc.nextInt();

        int maxFactor = 10;
        int[] factors = new int[maxFactor];
        int idx = 0;

        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                if (idx == maxFactor) {
                    maxFactor *= 2;
                    int[] tempFactors = new int[maxFactor];
                    for (int j = 0; j < factors.length; j++) {
                        tempFactors[j] = factors[j];
                    }
                    factors = tempFactors;
                }
                factors[idx] = i;
                idx++;
            }
        }

        System.out.print("The factors of " + num + " are: [");
        for (int i = 0; i < idx; i++) {
            System.out.print(factors[i]);
            if (i < idx - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        sc.close();
    }
}