package ShoppingCartSystem;

public class CartItem<T> {
    private final T item;
    private int qty;
    private final double price;

    public CartItem(T item, int qty, double price) {
        this.item = item;
        this.qty = qty;
        this.price = price;
    }

    public T getItem() {
        return item;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return  "Item : " + this.item
                + "\nQuantity : " + this.qty
                + "\nPrice per unit : ₹ " + this.price
                + "\nTotal : ₹ " + this.price * this.qty
                + "\n";
    }
}
