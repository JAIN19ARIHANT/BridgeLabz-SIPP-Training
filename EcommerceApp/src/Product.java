public class Product extends Item {
    protected String type;

    public Product (String itemId, String name, int price, String type) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    // Getters
    public String getId() { return itemId; }
    public String getName() { return name; }
    public int getPrice() { return price; }
    public  String getType() { return type; }


    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setType() {
        this.type = type;
    }


    @Override
    public void display() {
        System.out.println("Id : " + getId() + " Type : " + getType() + " Name : " + getName() + " Price : ₹" + getPrice());
    }
}
