import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Item i1 = new Item("Laptop", "Electronics", 70000);           // Expensive
        Item i2 = new Item("Blender", "Home Appliances", 5500);       // Home Appliance
        Item i3 = new Item("Treadmill", "Fitness", 12000);            // Expensive Fitness
        Item i4 = new Item("Headphones", "Electronics", 3900);
        Item i5 = new Item("Yoga Mat", "Fitness", 499);               // Below ₹500
        Item i6 = new Item("Smartwatch", "Electronics", 21000);       // Expensive
        Item i7 = new Item("Air Fryer", "Home Appliances", 8000);
        Item i8 = new Item("Dumbbells", "Fitness", 1500);
        Item i9 = new Item("Microwave", "Home Appliances", 9500);
        Item i10 = new Item("Monitor", "Electronics", 11000);         // Expensive
        Item i11 = new Item("Resistance Band", "Fitness", 300);
        Item i12 = new Item("Vacuum Cleaner", "Home Appliances", 13000); // Expensive
        Item i13 = new Item("Keyboard", "Electronics", 1050);
        Item i14 = new Item("Shoes", "Fitness", 2250);
        Item i15 = new Item("Mixer", "Home Appliances", 4000);
        Item i16 = new Item("Tablet", "Electronics", 18000);          // Expensive
        Item i17 = new Item("Cycle", "Fitness", 9500);
        Item i18 = new Item("Fan", "Home Appliances", 1500);
        Item i19 = new Item("", "Electronics", 5000);                 // Empty name
        Item i20 = new Item(null, "Fitness", 1200);                   // Null name

        List<Order> ordersA = List.of(
                new Order(LocalDate.now().minusDays(5), List.of(i1, i4)),
                new Order(LocalDate.now().minusDays(10), List.of(i2, i3)),
                new Order(LocalDate.now().minusDays(15), List.of(i5, i6)),
                new Order(LocalDate.now().minusDays(20), List.of(i7, i8)),
                new Order(LocalDate.now().minusDays(25), List.of(i9, i10)),
                new Order(LocalDate.now().minusDays(30), List.of(i11, i12)),
                new Order(LocalDate.now().minusDays(35), List.of(i13, i14))
        );

        List<Order> ordersB = List.of(
                new Order(LocalDate.now().minusDays(5), List.of(i15, i16)),
                new Order(LocalDate.now().minusDays(10), List.of(i17, i18)),
                new Order(LocalDate.now().minusDays(15), List.of(i19, i20)),
                new Order(LocalDate.now().minusDays(20), List.of(i1, i2)),
                new Order(LocalDate.now().minusDays(25), List.of(i3, i4)),
                new Order(LocalDate.now().minusDays(30), List.of(i5, i6)),
                new Order(LocalDate.now().minusDays(35), List.of(i7, i8))
        );

        List<Order> ordersC = List.of(
                new Order(LocalDate.now().minusDays(5), List.of(i9, i10)),
                new Order(LocalDate.now().minusDays(10), List.of(i11, i12)),
                new Order(LocalDate.now().minusDays(15), List.of(i13, i14)),
                new Order(LocalDate.now().minusDays(20), List.of(i15, i16)),
                new Order(LocalDate.now().minusDays(25), List.of(i17, i18)),
                new Order(LocalDate.now().minusDays(30), List.of(i19, i20))
        );

        Map<String, List<Store>> cityToStoresMap = getStringListMap(ordersA, ordersB, ordersC);

        SalesDashboard.analyzeSales(cityToStoresMap);
    }

    private static Map<String, List<Store>> getStringListMap(List<Order> ordersA, List<Order> ordersB, List<Order> ordersC) {
        Map<String, List<Order>> customerMap1 = Map.of("Arihant", ordersA);
        Map<String, List<Order>> customerMap2 = Map.of("Suryansh", ordersB);
        Map<String, List<Order>> customerMap3 = Map.of("Madhav", ordersC);

        Store store1 = new Store(customerMap1);
        Store store2 = new Store(customerMap2);
        Store store3 = new Store(customerMap3);

        return Map.of(
                "Delhi", List.of(store1),
                "Mumbai", List.of(store2),
                "Bangalore", List.of(store3)
        );
    }
}