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

    public void removeCheckpoint(String cpId) {
        Node temp = head;

        while (temp.Checkpoint.checkpointId.equals(cpId)) {
            temp = temp.next;
        }

        
    }

}
