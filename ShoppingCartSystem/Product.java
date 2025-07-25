package ShoppingCartSystem;

public class Product {
    private String name;

    public Product(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product that = (Product) o;
        return name.equalsIgnoreCase(that.name); // case-insensitive match
    }

    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode();
    }

}
