public class RouteLinkedList<T extends Checkpoint> {

    private final String RESET = "\u001b[0m";
    private final String RED = "\u001b[31m";
    private final String GREEN = "\u001b[32m";
    private final String BLUE = "\u001b[34m";

    class Node {
        T Checkpoint;
        Node next;

        Node(T cp) {
            Checkpoint = cp;
        }
    }

    private Node head;

    public void addCheckpoint(T cp) {
        Node nn = new Node(cp);

        if (head == null) {
            head = nn;
        }else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = nn;
        }
    }

    public boolean removeCheckpoint(String cpId) {
        if (head == null) return false;

        if (head.Checkpoint.getCheckpointId().equals(cpId)) {
            head = head.next;
            System.out.println("Checkpoint : " + cpId + " removed");
            return true;
        }

        Node prev = head;
        Node curr = head.next;

        while (curr != null) {
            if (curr.Checkpoint.getCheckpointId().equals(cpId)) {
                prev.next = curr.next;
                System.out.println("Checkpoint : " + cpId + " removed");
                return true;
            }
            prev = curr;
            curr = curr.next;
        }

        System.out.println("Checkpoint : " + cpId + " does not exist.");
        return false;
    }

    public T findCheckpoint(String cpId) {
        Node temp = head;
        while (temp != null) {
            if (temp.Checkpoint.getCheckpointId().equals(cpId)) {
                return temp.Checkpoint;
            }
            temp = temp.next;
        }
        System.out.println("Checkpoint : " + cpId + " does not exist.");
        return null;
    }

    public double totalDistance() {
        double distance = 0;
        Node temp = head;
        while (temp != null) {
            distance += temp.Checkpoint.getDistanceFromLast();
            temp = temp.next;
        }

        return distance;
    }

    public double totalPenalty() {
        double penalty = 0;
        Node temp = head;
        while (temp != null) {
            penalty += temp.Checkpoint.calculatePenalty();
            temp = temp.next;
        }

        return penalty;
    }

    public void printRoute() {
        Node current = head;
        int idx = 1;

        // Table Header
        System.out.printf("%-4s %-12s %-20s %-10s %-10s\n", "No.", "Type", "Location", "Status", "Penalty");
        System.out.println("---------------------------------------------------------------");

        while (current != null) {
            T cp = current.Checkpoint;
            boolean delayed = cp.isDelayed();
            double penalty = cp.calculatePenalty();

            String statusColor = delayed ? RED : GREEN;
            String statusText = delayed ? "Delayed" : "On Time";

            String penaltyColor = penalty > 0 ? RED : BLUE;
            String penaltyText = String.format("%.1f", penalty);

            System.out.printf("%-4d %-12s %-20s %s%-10s%s %s%-10s%s\n",
                    idx++, cp.getType(), cp.getLocationName(),
                    statusColor, statusText, RESET,
                    penaltyColor, penaltyText, RESET);

            current = current.next;
        }

        System.out.println("---------------------------------------------------------------");
    }

}
