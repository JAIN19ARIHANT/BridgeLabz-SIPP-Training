package SmartRestaurantMenu;

import java.util.List;

public class Dish {
    String name;
    String type;
    List<String> tags;
    int price;

    public Dish(String name, String type, List<String> tags, int price) {
        this.name = name.toLowerCase();
        this.type = type.toLowerCase();
        this.tags = tags.stream().map(String::toLowerCase).toList();
        this.price = price;
    }

    @Override
    public String toString() {
        return "Dish : " + name + "\nType : " + type + "\nTags : " + tags + "\nPrice : " + price;
    }
}
