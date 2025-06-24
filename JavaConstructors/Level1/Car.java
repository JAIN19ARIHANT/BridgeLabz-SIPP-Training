package JavaConstructors.Level1;

public class Car {
    private String customerName;
    private String carModel;
    private int rentalDays;
    private double dailyRate = 1000.0;

    public Car() {
        this.customerName = "Customer";
        this.carModel = "Basic";
        this.rentalDays = 1;
    }

    public Car(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    public double calculateTotalCost() {
        return rentalDays * dailyRate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public void setRentalDays(int rentalDays) {
        this.rentalDays = rentalDays;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public static void main(String[] args) {
        System.out.println("--- Car Rental Demonstration ---");

        Car defaultRental = new Car();
        System.out.println("Default Rental - Customer: " + defaultRental.getCustomerName() + ", Model: " + defaultRental.getCarModel() + ", Days: " + defaultRental.getRentalDays() + ", Total Cost: " + defaultRental.calculateTotalCost());

        Car customRental1 = new Car("Alice Smith", "Sedan", 5);
        System.out.println("Custom Rental 1 - Customer: " + customRental1.getCustomerName() + ", Model: " + customRental1.getCarModel() + ", Days: " + customRental1.getRentalDays() + ", Total Cost: " + customRental1.calculateTotalCost());

        Car customRental2 = new Car("Bob Johnson", "SUV", 3);
        customRental2.setDailyRate(1500.0);
        System.out.println("Custom Rental 2 - Customer: " + customRental2.getCustomerName() + ", Model: " + customRental2.getCarModel() + ", Days: " + customRental2.getRentalDays() + ", Daily Rate: " + customRental2.getDailyRate() + ", Total Cost: " + customRental2.calculateTotalCost());

        defaultRental.setCustomerName("Charlie Brown");
        defaultRental.setRentalDays(7);
        System.out.println("Updated Default Rental - Customer: " + defaultRental.getCustomerName() + ", Model: " + defaultRental.getCarModel() + ", Days: " + defaultRental.getRentalDays() + ", Total Cost: " + defaultRental.calculateTotalCost());

    }
}