package ShoppingCartSystem;

public class Main {
    public static void main(String[] args) {
        ShoppingCart<Product> cart = new ShoppingCart<>();

        cart.addItem(new Product("Laptop"), 1, 55000);
        cart.addItem(new Product("Book"), 2, 300);
        cart.addItem(new Product("Laptop"), 1, 55000); // duplicate allowed

        cart.showCart();

        System.out.println("\nTotal Price: ₹" + cart.calculateFinalAmount());

        cart.removeItem(new Product("Book"),9);
        cart.showCart();

        System.out.println("\nTotal Price: ₹" + cart.calculateFinalAmount());
    }
}
