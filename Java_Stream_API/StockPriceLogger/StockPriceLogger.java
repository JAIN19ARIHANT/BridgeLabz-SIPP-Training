import java.util.*;
public class StockPriceLogger {
    public static void main(String[] args) {
        List<Double> stockPrices = Arrays.asList(101.5, 102.3, 99.9, 100.2);
        System.out.println("Stock Price Logger:"); 
        stockPrices.forEach(p -> System.out.println("Price update: " + p));
    }
}
