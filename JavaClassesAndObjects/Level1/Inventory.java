class Inventory {
    int itemCode;
    String itemName;
    double price;

    Inventory(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    void displayDetails() {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price per unit: ₹" + price);
    }

    double calculateTotalCost(int quantity) {
        return price * quantity;
    }

    public static void main(String[] args) {
        Inventory item = new Inventory(347, "Notebook", 72);
        item.displayDetails();
        int quantity = 22;
        System.out.println("Total cost for " + quantity + " items: ₹" + item.calculateTotalCost(quantity));
    }
}