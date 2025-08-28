public class Driver {
    private final String driverId;
    private final String name;
    private final RouteLinkedList<Checkpoint> routeHistory;

    public Driver(String driverId, String name) {
        this.driverId = driverId;
        this.name = name;
        this.routeHistory = new RouteLinkedList<>();
    }

    public void addCheckpoint(Checkpoint cp) {
        routeHistory.addCheckpoint(cp);
    }

    public void printSummary() {
        System.out.println("Driver : " + this.driverId + " - " + this.name);
        System.out.println("\n------------------------\u001b[7m Route Summary \u001b[0m------------------------\n");
        routeHistory.printRoute();

        double totalDistance = routeHistory.totalDistance();
        double totalPenalty = routeHistory.totalPenalty();
        double routeScore = totalDistance - totalPenalty;

        System.out.printf("Total Distance : %.1f km\n", totalDistance);
        System.out.printf("Total Penalty  : %.1f\n", totalPenalty);
        System.out.printf("Route Score    : %.1f\n", routeScore);
    }
}
