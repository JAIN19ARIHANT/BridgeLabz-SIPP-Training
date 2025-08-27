public class RouteLinkedList<T extends Checkpoint> {
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
        if (head.Checkpoint.checkpointId.equals(cpId)) {
            head = head.next;
            System.out.println("Checkpoint : " + cpId + " removed");
            return true;
        }

        Node temp = head;

        while (temp != null && !temp.Checkpoint.checkpointId.equals(cpId)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Checkpoint : " + cpId + " does not exists.");
            return false;
        }

        temp.Checkpoint = temp.next.Checkpoint;
        temp.next = temp.next.next;

        System.out.println("Checkpoint : " + cpId + " removed");
        return true;
    }

    public T findCheckpoint(String cpId) {
        if (head.Checkpoint.checkpointId.equals(cpId)) {
            return head.Checkpoint;
        }

        Node temp = head;

        while (temp != null && !temp.Checkpoint.checkpointId.equals(cpId)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Checkpoint : " + cpId + " does not exists.");
            return null;
        }

        temp.Checkpoint = temp.next.Checkpoint;
        temp.next = temp.next.next;

        System.out.println("Checkpoint : " + cpId + " removed");

        return temp.Checkpoint;
    }

    public double totalDistance() {
        
    }


}
