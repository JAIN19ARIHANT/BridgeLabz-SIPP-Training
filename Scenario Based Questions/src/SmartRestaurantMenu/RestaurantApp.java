package SmartRestaurantMenu;

import java.util.ArrayList;
import java.util.HashSet;

public class RestaurantApp {
    ArrayList<Dish> menu;

    String OG = "\u001b[0m";
    String RED = "\u001b[31m";
    String BLUE = "\u001b[34m";
    String GREEN = "\u001b[32m";

    public RestaurantApp() {
        menu = new ArrayList<>();
    }

    public void addDish(Dish dish) {
        menu.add(dish);
    }

    public void removeDish(Dish dish) {
        menu.remove(dish);
    }

    public void searchDish(String keyword) {
        keyword = keyword.toLowerCase();
        ArrayList<String> result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();

        for (Dish d : menu) {
            final String finalKeyword = keyword;
            if (
                    d.name.contains(keyword) ||
                    d.type.contains(keyword) ||
                    d.tags.stream().anyMatch(str -> str.contains(finalKeyword))) {
                if (!set.contains(d.name)) {
                    result.add(d.name);
                    set.add(d.name);
                }
            }
        }

        if (result.isEmpty()) {
            System.out.println(GREEN + "\nKeyword : " + keyword + OG);
            System.out.println(RED + "\t\tItem not found!" + OG);
        }
        else {
            int i = 0;
            System.out.println(GREEN + "\nKeyword : " + keyword + OG);
            for (String str : result) {
                System.out.println("\t\t" + BLUE + ++i + ": " + str + OG);
            }
        }
    }
}