package SmartCheckout;

import java.util.*;

public class SmartCheckout {

    public static Map<String, Item> inventory = new HashMap<>();
    public static Queue<Customer> queue = new LinkedList<>();

    public static void main(String[] args) {

        Item.addItem("Milk", 55, 10);
        Item.addItem("Bread", 40, 5);
        Item.addItem("Rice", 60, 7);
        Item.addItem("Chocolate", 65, 12);

        Customer.addCustomer("Arihant", Arrays.asList("Milk", "Bread", "Juice"));
        Customer.addCustomer("Arjun", Arrays.asList("Rice", "Milk", "Milk"));
        Customer.addCustomer("Suryansh", Arrays.asList("Bread", "Ice-cream", "Chocolate"));

        while (!queue.isEmpty()) {
            Customer.processCheckout();
        }
    }
}