import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

public class SalesDashboard {
    public static void analyzeSales(Map<String, List<Store>> cityToStoresMap) {
        LocalDate sixtyDaysAgo = LocalDate.now().minusDays(60);

        List<Item> topAffordablePicks = cityToStoresMap.values().stream()
                .flatMap(List::stream)
                .flatMap(store -> store.getCustomerToOrdersMap().entrySet().stream())
                .filter(entry -> entry.getValue().stream()
                        .filter(order -> !order.getOrderDate().isBefore(sixtyDaysAgo))
                        .count() >= 3)
                .flatMap(entry -> entry.getValue().stream()
                        .flatMap(order -> order.getItems().stream()))
                .distinct()
                .sorted(Comparator.comparingDouble(Item::getPrice).reversed())
                .peek(item -> {
                    String rawName = item.getName() == null || item.getName().isEmpty() ? "<Unnamed>" : item.getName();
                    String formatted = String.format("%-20s", rawName); // align first
                    if (item.getName() == null || item.getName().isEmpty()) {
                        formatted = "\u001b[31m" + formatted + "\u001b[0m"; // then color
                    }
                    System.out.printf("%s | ₹%-10.2f\n", formatted, item.getPrice());
                })
                .skip(2)
                .limit(10)
                .collect(Collectors.toList());

        Map<String, List<Item>> itemsByCategory = topAffordablePicks.stream()
                .collect(Collectors.groupingBy(Item::getCategory));

        long electronicsCount = itemsByCategory.getOrDefault("Electronics", List.of()).size();
        boolean hasExpensiveItem = topAffordablePicks.stream().anyMatch(item -> item.getPrice() > 10000);
        boolean allAboveTen = topAffordablePicks.stream().allMatch(item -> item.getPrice() > 10);
        boolean noEmptyNames = topAffordablePicks.stream()
                .noneMatch(item -> item.getName() == null || item.getName().isEmpty());

        Optional<Item> firstHomeAppliance = itemsByCategory.getOrDefault("Home Appliances", List.of())
                .stream().findFirst();

        Optional<Item> anyFitnessItem = itemsByCategory.getOrDefault("Fitness", List.of())
                .stream().findAny();

        double totalValue = topAffordablePicks.stream()
                .map(Item::getPrice)
                .reduce(0.0, Double::sum);

        System.out.println("\n------------------- 🛍️ Sales Dashboard -------------------");
        System.out.printf ("%-25s : %s\n", "📦 Electronics Count", electronicsCount);
        System.out.printf ("%-25s : %s\n", "💰 Any item over ₹500?", hasExpensiveItem ? "Yes ✅" : "No ❌");
        System.out.printf ("%-25s : %s\n", "🔍 All items above ₹10?", allAboveTen ? "Yes ✅" : "No ❌");
        System.out.printf ("%-25s : %s\n", "📝 No empty item names?", noEmptyNames ? "Yes ✅" : "No ❌");
        System.out.printf ("%-25s : %s\n", "🏠 First Home Appliance",
                firstHomeAppliance.map(Item::getName).orElse("None"));
        System.out.printf ("%-26s : %s\n", "🏋️ Any Fitness Item",
                anyFitnessItem.map(Item::getName).orElse("None"));
        System.out.printf ("%-25s : ₹%.2f\n", "💳 Total Value of Picks", totalValue);
    }
}