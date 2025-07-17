package FoodFest;

public class Stall {
    private String name;
    private int footfall;

    public Stall (String name, int footfall) {
        this.name = name;
        this.footfall = footfall;
    }

    public void setName(String name) { this.name = name; }

    public void setFootfall(int footfall) { this.footfall = footfall; }

    public String getName() { return name; }

    public int getFootfall(){ return footfall; }

    @Override
    public String toString() {
        return  String.format("%-22s -\t\t %d Visitors", name, footfall);
    }
}
