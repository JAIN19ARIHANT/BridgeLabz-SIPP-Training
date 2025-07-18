package SmartRestaurantMenu;

import java.util.List;

public class SmartRestaurantMenu {
    public static void main(String[] args) {
        RestaurantApp menu = new RestaurantApp();

        menu.addDish(new Dish("Naan","Roti", List.of("Fresh", "Butter", "grilled"),60));
        menu.addDish(new Dish("Paneer Butter Massala","Sabji", List.of("spicy", "paneer"),350));
        menu.addDish(new Dish("Paneer Tikka","Starter", List.of("spicy", "paneer", "grilled"),270));
        menu.addDish(new Dish("Mojito","Drink", List.of("Cold", "Natural", "Icy"),100));

        menu.searchDish("Paneer");
        menu.searchDish("Drink");
        menu.searchDish("Pizza");

    }
}
