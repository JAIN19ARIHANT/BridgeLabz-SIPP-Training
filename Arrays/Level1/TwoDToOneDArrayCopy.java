package Level1;
import java.util.Scanner;

public class TwoDToOneDArrayCopy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of rows for the 2D array: ");
        int rows = sc.nextInt();

        System.out.print("Enter the number of columns for the 2D array: ");
        int cols = sc.nextInt();

        int[][] twoDArray = new int[rows][cols];

        System.out.println("Enter the elements for the 2D array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Enter element at [" + i + "][" + j + "]: ");
                twoDArray[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nOriginal 2D Array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(twoDArray[i][j] + "\t");
            }
            System.out.println();
        }

        int[] oneDArray = new int[rows * cols];
        int idx = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                oneDArray[idx] = twoDArray[i][j];
                idx++;
            }
        }

        System.out.print("\nCopied 1D Array: [");
        for (int i = 0; i < oneDArray.length; i++) {
            System.out.print(oneDArray[i]);
            if (i < oneDArray.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        sc.close();
    }
}
