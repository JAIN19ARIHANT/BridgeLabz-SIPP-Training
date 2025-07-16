package SmartCheckout;

public class Item {
    String name;
    double price;
    int stock;

    public Item(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public static void addItem(String name, double price, int stock) {
        SmartCheckout.inventory.put(name, new Item(name, price, stock));
    }
}