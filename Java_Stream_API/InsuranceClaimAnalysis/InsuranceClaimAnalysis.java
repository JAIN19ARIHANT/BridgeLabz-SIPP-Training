import java.util.*;
import java.util.stream.Collectors;
public class InsuranceClaimAnalysis {
    public static void main(String[] args) {
        List<InsuranceClaim> claims = Arrays.asList(
            new InsuranceClaim("Health", 12000.0),
            new InsuranceClaim("Auto", 8000.0),
            new InsuranceClaim("Health", 15000.0),
            new InsuranceClaim("Auto", 6000.0),
            new InsuranceClaim("Home", 20000.0)
        );
        System.out.println("Average claim amount by type:");
        Map<String, Double> avg = claims.stream()
                .collect(Collectors.groupingBy(InsuranceClaim::getType, Collectors.averagingDouble(InsuranceClaim::getAmount)));
        avg.forEach((type, amount) -> System.out.println(type + " -> " + String.format("%.2f", amount)));
    }
    static class InsuranceClaim {
        private String type;
        private double amount;
        public InsuranceClaim(String type, double amount) {
            this.type = type;
            this.amount = amount;
        }
        public String getType() { return type; }
        public double getAmount() { return amount; }
    }
}
