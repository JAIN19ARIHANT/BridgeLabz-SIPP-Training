package InsurancePolicyManagementSystem;

import java.time.LocalDate;
import java.util.*;

public class PolicyManager {
    Set<Policy> hashSet = new HashSet<>();
    Set<Policy> linkedHashSet = new LinkedHashSet<>();
    Set<Policy> treeSet = new TreeSet<>(new Comparator<Policy>() {
        @Override
        public int compare(Policy p1, Policy p2) {
            return p1.getExpDate().compareTo(p2.getExpDate());
        }
    });

    public void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    public void displayAll(Set<Policy> set) {
        for (Policy policy : set) {
            System.out.println(policy);
        }
    }

    public void displayExpiringSoon(Set<Policy> set) {
        LocalDate today = LocalDate.now();
        LocalDate limit = LocalDate.now().plusDays(30);

        for (Policy policy : set) {
            LocalDate expiry = policy.getExpDate();
            if (!(expiry.isBefore(today)) && expiry.isBefore(limit)) {
                System.out.println("\u001b[33m" + policy + "\u001b[0m");
            }
        }
    }

    public void displayExpired(Set<Policy> set) {
        LocalDate today = LocalDate.now();

        for (Policy policy : set) {
            LocalDate expiry = policy.getExpDate();
            if (expiry.isBefore(today)) {
                System.out.println("\u001b[31m" + policy + "\u001b[0m");
            }
        }
    }

    public void displayByCoverage(Set<Policy> set, Coverage coverage) {
        for (Policy policy : set) {
            if (policy.getCoverage().equals(coverage)) {
                System.out.println(policy);
            }
        }
    }

    public void findDuplicates(List<Policy> list) {
        Set<String> seen = new HashSet<>();
        Set<String> duplicate = new HashSet<>();

        for (Policy p : list) {
            if (!seen.add(p.getPolicyNo())) {
                duplicate.add(p.getPolicyNo());
            }
        }

        if (!duplicate.isEmpty()) {
            System.out.println("🔴 Duplicate Policy Numbers: " + duplicate);
        } else {
            System.out.println("\n🔹 No Duplicates found in database !!");
        }
    }


    public void comparePerformance(List<Policy> policies) {

        long startHash = System.nanoTime();
        Set<Policy> hSet = new HashSet<>();
        for (Policy p : policies) {
            hSet.add(p);
            hSet.contains(p);
            hSet.remove(p);
        }
        long endHash = System.nanoTime();

        long startLinked = System.nanoTime();
        Set<Policy> lSet = new LinkedHashSet<>();
        for (Policy p : policies) {
            hSet.add(p);
            hSet.contains(p);
            hSet.remove(p);
        }
        long endLinked = System.nanoTime();

        long startTree = System.nanoTime();
        Set<Policy> tSet = new TreeSet<>(new Comparator<Policy>() {
            public int compare(Policy p1, Policy p2) {
                return p1.getExpDate().compareTo(p2.getExpDate());
            }
        });
        for (Policy p : policies) {
            hSet.add(p);
            hSet.contains(p);
            hSet.remove(p);
        }
        long endTree = System.nanoTime();

        System.out.println("\n---------------- Performance Comparison ----------------");
        System.out.println("HashSet: " + (endHash - startHash)/1_000 + " µs");
        System.out.println("LinkedHashSet: " + (endLinked - startLinked)/1_000 + " µs");
        System.out.println("TreeSet: " + (endTree - startTree)/1_000 + " µs");
        System.out.println("--------------------------------------------------------\n");
    }

}
