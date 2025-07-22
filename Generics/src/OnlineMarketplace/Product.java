package OnlineMarketplace;

public class Product<T> {
    private final String name;
    private double price;
    private final T category;

    public Product (String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() { return this.name; }

    public double getPrice() { return this.price; }

    public T getCategory() { return this.category; }

    public void setPrice(double newPrice) { this.price = newPrice; }

    @Override
    public String toString() {
        return String.format("Product : %s, Price : %.2f, Category : %s", this.name, this.price, this.category);
    }
}