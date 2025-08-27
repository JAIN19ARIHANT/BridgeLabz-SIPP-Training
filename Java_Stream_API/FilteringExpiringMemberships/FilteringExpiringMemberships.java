import java.time.LocalDate;
import java.util.*;
public class FilteringExpiringMemberships {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        List<Member> members = Arrays.asList(
            new Member("Alice", today.plusDays(10)),
            new Member("Bob", today.plusDays(40)),
            new Member("Charlie", today.plusDays(20)),
            new Member("David", today.minusDays(2))
        );
        System.out.println("Expiring memberships within 30 days:");
        members.stream()
                .filter(m -> !m.getExpiryDate().isBefore(today) && m.getExpiryDate().isBefore(today.plusDays(30)))
                .forEach(System.out::println);
    }
    static class Member {
        private String name;
        private LocalDate expiryDate;
        public Member(String name, LocalDate expiryDate) {
            this.name = name;
            this.expiryDate = expiryDate;
        }
        public String getName() { return name; }
        public LocalDate getExpiryDate() { return expiryDate; }
        public String toString() { return name + " - Expiry: " + expiryDate; }
    }
}
