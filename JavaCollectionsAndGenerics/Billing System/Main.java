public class Main {
    public static void main(String[] args) {
        ShoppingCartManager<Electronics> electronicsManager = new ShoppingCartManager<>();
        ShoppingCartManager<Groceries> groceriesManager = new ShoppingCartManager<>();
        ShoppingCartManager<Apparel> apparelManager = new ShoppingCartManager<>();

        electronicsManager.addItem(new Electronics("Laptop", 1, 60_000));
        electronicsManager.addItem(new Electronics("Headphones", 2, 3000));
        electronicsManager.addItem(new Electronics("Laptop", 1, 60_000));

        groceriesManager.addItem(new Groceries("Apples", 5, 40));
        groceriesManager.addItem(new Groceries("Milk", 2, 60));
        groceriesManager.addItem(new Groceries("Apples", 3, 45));

        apparelManager.addItem(new Apparel("T-Shirt", 2, 500));
        apparelManager.addItem(new Apparel("Jeans", 1, 1200));
        apparelManager.addItem(new Apparel("T-Shirt", 4, 500));

        System.out.println("\nElectronics Cart:");
        electronicsManager.printCart();

        System.out.println("\nGroceries Cart:");
        groceriesManager.printCart();

        System.out.println("\nApparel Cart:");
        apparelManager.printCart();
    }
}