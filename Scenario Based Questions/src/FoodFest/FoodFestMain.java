package FoodFest;

import java.util.*;

public class FoodFestMain {
    public static void main(String[] args) {

        List<Stall> zoneA = new ArrayList<>(List.of(
                new Stall("Massala Town", 120),
                new Stall("Chaat Corner", 180)
        ));

        List<Stall> zoneB = new ArrayList<>(List.of(
                new Stall("Burger Hut", 180),
                new Stall("Pizza King", 130)
        ));

        List<Stall> zoneC = new ArrayList<>(List.of(
                new Stall("Southern Foods", 110),
                new Stall("Street Style", 190)
        ));

        Comparator<Stall> footfallComparator = Comparator.comparingInt(Stall::getFootfall);
        zoneA.sort(footfallComparator);
        zoneB.sort(footfallComparator);
        zoneC.sort(footfallComparator);

        List<List<Stall>> allZones = new ArrayList<>();
        allZones.add(zoneA);
        allZones.add(zoneB);
        allZones.add(zoneC);

        List<Stall> masterList = StallSort.mergeAllZones(allZones);

        System.out.println("\n🍽️ Final Sorted Footfall Across All Zones:");
        System.out.println("+----------------------+---------------------------+");
        for (Stall stall : masterList) {
            System.out.println(stall);
        }
    }
}