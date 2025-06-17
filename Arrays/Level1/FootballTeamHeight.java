package Level1;
import java.util.Scanner;

public class FootballTeamHeight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] heights = new double[11];
        double sum = 0.0;

        System.out.println("Enter the heights of 11 football players:");

        for (int i = 0; i < 11; i++) {
            System.out.print("Enter height for player " + (i + 1) + ": ");
            heights[i] = sc.nextDouble();
            sum += heights[i];
        }

        double meanHeight = sum / 11;

        System.out.println("The mean height of the football team is: " + meanHeight);

        sc.close();
    }
}