public class Apparel extends ShoppingCart {
    private final String type;

    public Apparel (String itemName, int qty, double pricePerUnit) {
        super(itemName, qty, pricePerUnit);
        this.type = "Apparel";
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return super.toString() + "\nType  : " + type;
    }
}
