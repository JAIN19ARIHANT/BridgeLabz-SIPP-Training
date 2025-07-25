package ShoppingCartSystem;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart<T> {

    private final List<CartItem> cartItemsList = new ArrayList<>();

    public void addItem(T item, int qty, double price) {
        cartItemsList.add(new CartItem(item,qty,price));
        System.out.println("\nItem : " + item + " added to cart Successfully !\n");
    }

    public void removeItem(T item, int qty) {
//        cartItemsList.removeIf(items -> items.getItem().equals(item));

        boolean found = false;

        for (CartItem c : cartItemsList) {
            if (c.getItem().equals(item)) {
                found = true;
                if (c.getQty() >= qty) {
                    System.out.println(qty + " " + item + " removed from cart.");
                    c.setQty(c.getQty() - qty);
                }else {
                    System.out.println("All " + item + " removed from cart !");
                    cartItemsList.remove(c);
                }
            }
        }

        if (!found) {
            System.out.println("\n⚠️ No such item in cart !");
        }
    }

    public void showCart() {
        System.out.println("\n------------------ CART ------------------");
        for (CartItem c : cartItemsList) {
            System.out.println(c);
        }
        System.out.println("------------------------------------------\n");
    }

    public double calculateFinalAmount() {
        double paisa = 0;

        for (CartItem c : cartItemsList) {
            paisa += c.getPrice() * c.getQty();
        }

        return paisa;
    }

}
