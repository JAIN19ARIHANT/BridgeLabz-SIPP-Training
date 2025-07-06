import java.util.*;

abstract class Parcel {
    double weight;
    double width,length,height;

    Parcel (double weight, double width, double length, double height) {
        this.weight = weight;
        this.width = width;
        this.length = length;
        this.height = height;
    }

    public abstract double calculateShippingCost();

    public double volume () {
        return length * width * height;
    }

    public void showDetails() {
        System.out.println("Weight : " + weight + " Kg\nVolume : " + volume());
    }
}

class StandardParcel extends Parcel {
    StandardParcel(double weight, double length, double width, double height) {
        super(weight, length, width, height);
    }

    @Override
    public double calculateShippingCost() {
        return 50 + weight * 10 + volume() * 0.01;
    }
}

class ExpressParcel extends Parcel {
    ExpressParcel(double weight, double length, double width, double height) {
        super(weight, length, width, height);
    }

    @Override
    public double calculateShippingCost() {
        return 100 + weight * 15 + volume() * 0.02;
    }
}

class InternationalParcel extends Parcel {
    InternationalParcel(double weight, double length, double width, double height) {
        super(weight, length, width, height);
    }

    @Override
    public double calculateShippingCost() {
        return 200 + weight * 25 + volume() * 0.03;
    }
}

public class ShippingService {
    public static void main(String[] args) {
        List<Parcel> parcels = new ArrayList<>();
        parcels.add(new StandardParcel(2.5, 30, 20, 10));
        parcels.add(new ExpressParcel(1.2, 25, 15, 8));
        parcels.add(new InternationalParcel(4.0, 50, 40, 30));

        ShippingService service = new ShippingService();
        service.processParcels(parcels);
    }

    public void processParcels(List<Parcel> parcels) {
        for (Parcel p : parcels) {
            System.out.println("-------------------------------------");
            p.showDetails();
            double cost = p.calculateShippingCost();
            System.out.println("Shipping Cost: ₹" + cost);
        }
    }

}