public class Electronics extends ShoppingCart {
    private final String type;

    public Electronics (String itemName, int qty, double pricePerUnit) {
        super(itemName, qty, pricePerUnit);
        this.type = "Electronics";
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return super.toString() + "\nType  : " + type;
    }

}
