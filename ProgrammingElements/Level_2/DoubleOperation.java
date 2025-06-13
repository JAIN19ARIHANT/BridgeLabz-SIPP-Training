import java.util.Scanner;
public class DoubleOperation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double a = input.nextDouble(), b = input.nextDouble(), c = input.nextDouble();
        double res1 = a + b * c, res2 = a * b + c, res3 = c + a / b, res4 = a % b + c;
        System.out.println("The results of Double Operations are " + res1 + ", " + res2 + ", " + res3 + ", and " + res4);
    }
}