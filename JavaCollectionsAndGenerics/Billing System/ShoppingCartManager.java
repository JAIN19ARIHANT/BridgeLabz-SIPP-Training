import java.util.*;

public class ShoppingCartManager <T extends ShoppingCart> {
    public List<T> shoppingList = new ArrayList<>();

    Set<String> itemSet = new HashSet<>();

    public void addItem(T item) {
        if (!itemSet.contains(item.getItemName())) {
            shoppingList.add(item);
            itemSet.add(item.getItemName().toLowerCase());
        }else {
            for (T existingItem : shoppingList) {
                if (existingItem.getItemName().equalsIgnoreCase(item.getItemName()) &&
                        existingItem.getPricePerUnit() == item.getPricePerUnit()) {
                    existingItem.setQty(existingItem.getQty() + item.getQty());
                }
            }
        }
    }

    public boolean itemInCart(T item) {
        return shoppingList.contains(item);
    }

    public void printCart() {
        shoppingList.forEach(item -> System.out.printf(
                        "- %s x %d @ ₹%.2f each → ₹%.2f%n",
                        item.getItemName(),
                        item.getQty(),
                        item.getPricePerUnit(),
                        item.getTotalPrice()
                ));
    }

    public double getCartTotal() {
        double sum = 0;
        for (T item : shoppingList) {
            sum += item.getTotalPrice();
        }
        return sum;
    }

}
