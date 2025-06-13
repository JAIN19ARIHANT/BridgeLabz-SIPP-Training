import java.util.Scanner;
public class IntOperation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt(), b = input.nextInt(), c = input.nextInt();
        int res1 = a + b * c, res2 = a * b + c, res3 = c + a / b, res4 = a % b + c;
        System.out.println("The results of Int Operations are " + res1 + ", " + res2 + ", " + res3 + ", and " + res4);
    }
}