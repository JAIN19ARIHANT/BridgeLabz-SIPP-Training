package Level1;

import java.util.Scanner;
public class CanVote {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n  =10;

        int[] age = new int[n];

        System.out.println("Enter the ages of all the 10 students : ");

        for (int i = 0; i < n; i++) {
            age[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (age[i] < 1)
                System.err.println(age[i] + " Invalid Age.");

            else if (age[i] >= 1 && age[i] < 18)
                System.out.println("The student with the age " + age[i] + " cannot vote.");

            else
                System.out.println("The student with the age " + age[i] + " can vote");
        }
    }
}
