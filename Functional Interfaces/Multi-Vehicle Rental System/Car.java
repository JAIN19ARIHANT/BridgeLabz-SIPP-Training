class Car implements Rentable {
    private final String brand;
    private final String model;
    private boolean isRented;

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
        isRented = false;
    }

    @Override
    public void returnVehicle() {
        if (isRented()) {
            this.isRented = false;
            System.out.printf("%s - %s Returned Successfully.\n",brand, model);
        } else {
            System.out.printf(RED + "%s - %s was not rented !\n" + RESET, brand, model);
        }
    }

    @Override
    public boolean isRented() {
        return this.isRented;
    }

    @Override
    public void rent() {
        if (isRented()) {
            System.out.printf(RED + "%s - %s is not available for rent.\n" + RESET,brand, model);
        }else {
            isRented = true;
            System.out.printf("%s - %s rented Successfully.\n",brand, model);
        }
    }

    @Override
    public String toString() {
        return this.brand + " " + this.model;
    }
}