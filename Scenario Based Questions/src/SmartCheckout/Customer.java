package SmartCheckout;

import java.util.*;

public class Customer {
    String name;
    List<String> cart;

    public Customer(String name, List<String> cart) {
        this.name = name;
        this.cart = cart;
    }

    public static void addCustomer(String name, List<String> cart) {
        SmartCheckout.queue.add(new Customer(name, cart));
    }

    public static void processCheckout() {
        if (SmartCheckout.queue.isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        Customer customer = SmartCheckout.queue.poll();
        double total = 0;

        Map<String, Integer> itemCounts = new HashMap<>();
        for (String itemName : customer.cart) {
            itemCounts.put(itemName, itemCounts.getOrDefault(itemName, 0) + 1);
        }

        System.out.println("\n🧾 BILL FOR: " + customer.name);
        System.out.println("-----------------------------------------------------------");
        System.out.printf("%-20s %-10s %-10s %-10s%n", "Item", "Qty", "Unit (₹)", "Subtotal");
        System.out.println("-----------------------------------------------------------");

        for (Map.Entry<String, Integer> entry : itemCounts.entrySet()) {
            String itemName = entry.getKey();
            int quantity = entry.getValue();
            Item item = SmartCheckout.inventory.get(itemName);

            if (item != null && item.stock >= quantity) {
                double subtotal = item.price * quantity;
                total += subtotal;
                item.stock -= quantity;

                System.out.printf("%-20s %-10d %-10.2f %-10.2f%n", item.name, quantity, item.price, subtotal);
            } else {
                System.out.printf("%-20s %-10s %-10s %-10s%n", itemName, "--", "--", "Unavailable");
            }
        }

        System.out.println("-----------------------------------------------------------");
        System.out.printf("%-20s %-30s ₹%.2f%n", "Total", "", total);
        System.out.println("-----------------------------------------------------------\n");
    }
}