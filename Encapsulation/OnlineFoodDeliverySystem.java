import java.util.*;

interface Discountable {
    void applyDiscount(double percent);
    String getDiscountDetails();
}

abstract class FoodItem {
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    private String itemName;
    private double price;
    private int quantity;

    FoodItem (String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract double calculateTotalPrice();

    public String getItemDetails() {
        return "Name : " + itemName + "\nPrice : ₹ " + price + "\nQuantity : " + quantity;
    }

    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
}

class VegItem extends FoodItem {
    public VegItem (String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }
}

class NonVegItem extends FoodItem {
    private static final double NonVeg_charge = 50;
    public NonVegItem (String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() + NonVeg_charge) * getQuantity();
    }
}

class DiscountedItem implements Discountable {
    private FoodItem item;
    private double discountedPrice;

    DiscountedItem (FoodItem item) {
        this.item = item;
        this.discountedPrice = item.calculateTotalPrice();
    }

    @Override
    public void applyDiscount(double percent) {
        double discount = (percent/100) * discountedPrice;
        discountedPrice -= discount;
    }

    @Override
    public String getDiscountDetails() {
//        return FoodItem.GREEN + "Final Price : ₹ " + discountedPrice + FoodItem.RESET;
        return FoodItem.GREEN +
                "Original Price : ₹" + item.calculateTotalPrice() + "\n" +
                "Discount Applied : ₹" + (item.calculateTotalPrice() - discountedPrice) + "\n" +
                "Final Price : ₹" + discountedPrice +
                FoodItem.RESET +
                "\n--------------------------------";
    }
}

class Order {
    public static void order(FoodItem item) {
        System.out.println("\n" + item.getItemDetails());
        if (item.getQuantity() == 1) System.out.println("Final Price : " + item.getPrice());
        System.out.println("--------------------------------");
    }
}

public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        FoodItem veg = new VegItem("Dal-Chawal",120,2);
        FoodItem nonVeg = new NonVegItem("Pizza",200,1);

        Order.order(veg);

        DiscountedItem discountVeg = new DiscountedItem(veg);
        discountVeg.applyDiscount(25);
        System.out.println(discountVeg.getDiscountDetails());

        Order.order(nonVeg);
    }
}