public class Main {
    public static void main(String[] args) {
        Rentable car1 = new Car("Toyota", "Mirai");
        Rentable car2 = new Car("Lamborghini", "Huracan");

        Rentable bike1 = new Bike("Ola", "Roadster");

        Rentable bus1 = new Bus("Mercedes-Benz", "Citaro");
        Rentable bus2 = new Bus("Tata", "Marcopolo");

        car1.returnVehicle();
        car1.rent();
        car2.rent();
        car2.returnVehicle();
        bus1.rent();

        CheckIfRented cir = vehicle -> {
            String status = vehicle.isRented() ? "Rented" : "Not Rented";
            System.out.println("Vehicle : " + vehicle + " is " + status);
        };

        cir.check(bus1);
    }
}