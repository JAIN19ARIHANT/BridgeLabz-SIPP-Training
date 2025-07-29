public class Groceries extends ShoppingCart {
    private final String type;

    public Groceries (String itemName, int qty, double pricePerUnit) {
        super(itemName, qty, pricePerUnit);
        this.type = "Groceries";
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return super.toString() + "\nType  : " + type;
    }
}
