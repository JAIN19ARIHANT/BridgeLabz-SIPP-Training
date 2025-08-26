public class DriverDetails {
    private String driverId;
    private String name;
    private RouteLinkedList<Checkpoint> routeHistory;

    public DriverDetails(String driverId, String name, RouteLinkedList<Checkpoint> routeHistory) {
        this.driverId = driverId;
        this.name = name;
        this.routeHistory = routeHistory;
    }

    public void printDetails() {
        System.out.println("Driver : " + driverId + " " + name);
        System.out.println("Route Details : ");


    }


}
