import java.util.*;

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

abstract class Product {
    private String productId;
    private String name;
    private double price;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public abstract double calculateDiscount();

    public void displayDetails() {
        System.out.println("Product ID: " + productId + ", Name: " + name + ", Price: ₹ " + price + "\n");
    }
}

class Electronics extends Product implements Taxable {
    private double taxRate;
    private double discount;

    public Electronics(String productId, String name, double price, double discount, double taxRate) {
        super(productId, name, price);
        this.discount = discount;
        this.taxRate = taxRate;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * discount;
    }

    @Override
    public double calculateTax() {
        return getPrice() * taxRate;
    }

    @Override
    public String getTaxDetails() {
        return "Electronics Tax: ₹ " + calculateTax();
    }
}

class Clothing extends Product implements Taxable {
    private double flatDiscount;
    private double taxRate;

    public Clothing(String productId, String name, double price, double flatDiscount, double taxRate) {
        super(productId, name, price);
        this.flatDiscount = flatDiscount;
        this.taxRate = taxRate;
    }

    @Override
    public double calculateDiscount() {
        return flatDiscount;
    }

    @Override
    public double calculateTax() {
        return getPrice() * taxRate;
    }

    @Override
    public String getTaxDetails() {
        return "Clothing Tax: ₹ " + calculateTax();
    }
}

class Groceries extends Product {
    private double seasonalDiscount;

    public Groceries(String productId, String name, double price, double seasonalDiscount) {
        super(productId, name, price);
        this.seasonalDiscount = seasonalDiscount;
    }

    @Override
    public double calculateDiscount() {
        return seasonalDiscount;
    }
}

public class ECommercePlatform {
    public static void calculateFinalPrice(List<Product> productList) {
        for (Product p : productList) {
            double price = p.getPrice();
            double discount = p.calculateDiscount();
            double tax = (p instanceof Taxable) ? ((Taxable) p).calculateTax() : 0.0;

            p.displayDetails();
            if (p instanceof Taxable) {
                System.out.println(((Taxable) p).getTaxDetails());
            }
            System.out.println("Discount: ₹ " + discount);
            System.out.println("Final Price: ₹ " + (price + tax - discount) + "\n");
        }
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Electronics("E101", "Laptop", 80000, 0.10, 0.18));
        products.add(new Clothing("C202", "T-Shirt", 1200, 150, 0.05));
        products.add(new Groceries("G303", "Rice", 1800, 100));

        calculateFinalPrice(products);
    }
}