import java.util.Scanner;

public class CalculateTotalPrice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the unit price of the item (e.g., 15.75): ₹");
        double unitPrice = sc.nextDouble();

        System.out.print("Enter the quantity to be bought (e.g., 5): ");
        int quantity = sc.nextInt();

        double totalPrice = unitPrice * quantity;

        System.out.println("The total purchase price is ₹" + String.format("%.2f", totalPrice) +
                " if the quantity is " + quantity +
                " and unit price is ₹" + String.format("%.2f", unitPrice));

        sc.close();
    }
}