public class ShoppingCart {
    private final String itemName;
    private int qty;
    private final double pricePerUnit;

    public ShoppingCart(String itemName, int qty, double pricePerUnit) {
        this.itemName = itemName;
        this.qty = qty;
        this.pricePerUnit = pricePerUnit;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int newQty) {
        this.qty = newQty;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    @Override
    public String toString() {
        return  "\nName  : " + this.itemName +
                "\nQty   : " + this.qty +
                "\ncost  : " + this.pricePerUnit +
                "\nTotal : " + getTotalPrice();
    }

    public double getTotalPrice() {
        return qty * pricePerUnit;
    }

    @Override
    public int hashCode() {
        return itemName.toLowerCase().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)  return true;
        if (o == null || this.getClass() != o.getClass())   return false;
        ShoppingCart other = (ShoppingCart) o;
        return itemName.equalsIgnoreCase(other.itemName);
    }
}
