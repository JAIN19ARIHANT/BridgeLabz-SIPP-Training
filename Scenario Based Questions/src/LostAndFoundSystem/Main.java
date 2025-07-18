package LostAndFoundSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class LostAndFound {
    HashMap<String, ArrayList<String>> map;

    LostAndFound () {
        map = new HashMap<>();
        set = new HashSet<>();
    }

    HashSet<String> set = new HashSet<>();

    public void add(String item, String desc) {
        item = item.toLowerCase();
        if (!map.containsKey(item)) {
            ArrayList<String> ll = new ArrayList<>();
            ll.add(desc);
            map.put(item,ll);
            set.add(item);
        }
        else {
            map.get(item).add(desc);
        }
    }

    public ArrayList<Integer> find(String type, String str) {
        type = type.toLowerCase();
        ArrayList<String> al = map.get(type);

        ArrayList<Integer> ans = new ArrayList<>();
        if (al != null) {
            for (int i = 0; i < al.size(); i++) {
                if (al.get(i) != null && al.get(i).toLowerCase().contains(str.toLowerCase())) {
                    ans.add(i);
                }
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        LostAndFound lf = new LostAndFound();

        lf.add("Smartphone","Apple, Red, 256gb");
        lf.add("Bag","Puma, Black, 30lt, new");
        lf.add("Bag","HP, white, 22lt, old, rugged");

        System.out.println(lf.find("bag","hp"));
    }
}
