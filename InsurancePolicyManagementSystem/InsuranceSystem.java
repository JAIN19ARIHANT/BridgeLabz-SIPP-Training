package InsurancePolicyManagementSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InsuranceSystem {
    public static void main(String[] args) {
        PolicyManager pm = new PolicyManager();

        pm.addPolicy(new Policy("P101","Arihant", LocalDate.now().plusDays(1),Coverage.HEALTH,18250));
        pm.addPolicy(new Policy("P202","Suryansh", LocalDate.now().plusDays(40),Coverage.LIFE,22500.50));
        pm.addPolicy(new Policy("P303","Arjun", LocalDate.now().plusDays(200),Coverage.AUTO,12000));
        pm.addPolicy(new Policy("P404","Deepanshu", LocalDate.now().minusDays(8),Coverage.HEALTH,15799.99));
        pm.addPolicy(new Policy("P303","Tarun", LocalDate.now().plusDays(0),Coverage.TRAVEL,0.75));

        System.out.println("\n🔹 All unique Policies : (Hash Set)");
        pm.displayAll(pm.hashSet);

        System.out.println("\n🔹 All unique Policies : (Tree Set)");
        pm.displayAll(pm.treeSet);

        System.out.println("\n🔹 All unique Policies : (Linked Hash Set)");
        pm.displayAll(pm.linkedHashSet);

        System.out.println("\n🔹 Expiring Soon : ");
        pm.displayExpiringSoon(pm.linkedHashSet);

        System.out.println("\n🔹 Expired : ");
        pm.displayExpired(pm.treeSet);

        System.out.println("\n🔹 Policies with Coverage Type 'Auto':");
        pm.displayByCoverage(pm.hashSet, Coverage.AUTO);

        System.out.println("\n🔹 Duplicate Policies : ");
        List<Policy> allPolicies = new ArrayList<>(pm.hashSet);
//        allPolicies.addAll(pm.treeSet);
        pm.findDuplicates(allPolicies);

        pm.comparePerformance(allPolicies);

    }
}
