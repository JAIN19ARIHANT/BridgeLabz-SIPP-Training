package Static&Final.Level1;

public class Product {

    private static double discount = 0.05;

    private final String productID;
    private String productName;
    private double price;
    private int quantity;

    public static void main(String[] args) {
        System.out.println("Welcome to our online store!");

        Product item1 = new Product("PROD001", "Laptop", 1200.00, 1);
        Product item2 = new Product("PROD002", "Mouse", 25.00, 2);
        Product item3 = new Product("PROD003", "Keyboard", 75.00, 1);

        if (item1 instanceof Product) {
            System.out.println("\nChecking item1 type using instanceof:");
            item1.displayProductDetails();
        }

        if (item2 instanceof Product) {
            item2.displayProductDetails();
        }
        if (item3 instanceof Product) {
            item3.displayProductDetails();
        }

        System.out.println("\nInitial global discount: " + (Product.discount * 100) + "%");
        Product.updateDiscount(0.10);
        System.out.println("Updated global discount: " + (Product.discount * 100) + "%");

        System.out.println("\n--- Product Details after Discount Update ---");
        item1.displayProductDetails();
        item2.displayProductDetails();
        item3.displayProductDetails();

        Object nonProduct = "This is not a product object";
        if (nonProduct instanceof Product) {
            System.out.println("\nnonProduct is an instance of Product.");
        } else {
            System.out.println("\nnonProduct is NOT an instance of Product.");
        }
    }

    public Product(String productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public static void updateDiscount(double newDiscount) {
        if (newDiscount >= 0 && newDiscount <= 1) {
            discount = newDiscount;
            System.out.println("Discount updated to: " + (discount * 100) + "%");
        } else {
            System.out.println("Invalid discount percentage. Must be between 0 and 1.");
        }
    }

    public double calculateFinalPrice() {
        return (price * quantity) * (1 - discount);
    }

    public void displayProductDetails() {
        System.out.println("\n--- Item Details ---");
        System.out.println("Product ID: " + productID);
        System.out.println("Name: " + productName);
        System.out.println("Unit Price: ₹" + String.format("%.2f", price));
        System.out.println("Quantity: " + quantity);
        System.out.println("Current Discount: " + (discount * 100) + "%");
        System.out.println("Final Price (after discount): ₹" + String.format("%.2f", calculateFinalPrice()));
        System.out.println("---------------------");
    }
}