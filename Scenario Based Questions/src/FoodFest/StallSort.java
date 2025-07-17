package FoodFest;

import java.util.ArrayList;
import java.util.List;

public class StallSort {
    public static List<Stall> mergeSortedLists(List<Stall> l1, List<Stall> l2) {
        List<Stall> merged = new ArrayList<>();

        int i = 0, j = 0;

        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i).getFootfall() <= l2.get(j).getFootfall()) {
                merged.add(l1.get(i++));
            }
            else
                merged.add(l2.get(j++));
        }

        while (i < l1.size())
            merged.add(l1.get(i++));

        while (j < l2.size())
            merged.add(l2.get(j++));

        return merged;
    }

    public static List<Stall> mergeAllZones(List<List<Stall>> zoneLists) {
        if (zoneLists == null || zoneLists.isEmpty()) return new ArrayList<>();

        while (zoneLists.size() > 1) {
            List<Stall> merged = mergeSortedLists(zoneLists.remove(0), zoneLists.remove(0));
            zoneLists.add(0, merged);
        }

        return zoneLists.get(0);
    }

}
