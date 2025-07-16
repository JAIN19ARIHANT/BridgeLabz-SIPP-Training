package IceCreamRush;

public class IceCreamRush {
    public static void main(String[] args) {
        Flavour[] flavours = {
                new Flavour("Vanilla", 30),
                new Flavour("Chocolate", 30),
                new Flavour("Strawberry", 30),
                new Flavour("Butterscotch", 30),
                new Flavour("Coffee", 40),
                new Flavour("Mango", 50),
                new Flavour("Dark Chocolate", 50),
                new Flavour("Belgium Chocolate", 80)
        };

        FlavourSort fs = new FlavourSort();
        fs.bubbleSort(flavours);

        for (Flavour flavor : flavours) {
            System.out.println(flavor.getName() + " - " + flavor.getSales());
        }


    }
}
