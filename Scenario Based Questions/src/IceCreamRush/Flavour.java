package IceCreamRush;

public class Flavour {
    String name;
    private int sales;

    Flavour(String name, int sales) {
        this.name = name;
        this.sales = sales;
    }

    public String getName(){
        return name;
    }

    public int getSales() {
        return sales;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public void swap(Flavour f2) {
        String tempName = this.name;
        int tempSales = this.sales;

        this.name = f2.name;
        this.sales = f2.sales;

        f2.name = tempName;
        f2.sales = tempSales;
    }
}
