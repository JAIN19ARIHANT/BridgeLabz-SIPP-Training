public class Item {
    String name;
    String Category;
    double price;

    public Item(String name, String category, double price) {
        this.name = name;
        Category = category;
        this.price = price;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getCategory() { return Category; }

    public void setCategory(String category) {
        Category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return name != null && name.equals(item.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return name + " (₹ " + price + ")";
    }
}