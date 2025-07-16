package IceCreamRush;

public class FlavourSort {
    public void bubbleSort(Flavour[] flavours) {
        int n = flavours.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (flavours[j].getSales() > flavours[j + 1].getSales()) {
                    flavours[j].swap(flavours[j + 1]);
                }
            }
        }
    }
}