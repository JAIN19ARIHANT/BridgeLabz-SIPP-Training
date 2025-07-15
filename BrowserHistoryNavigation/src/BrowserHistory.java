public class BrowserHistory implements Navigation{

    private HistoryNode current;

    public void visit(String url) {
        HistoryNode newNode = new HistoryNode(url);

        if (current != null) {
            current.next = newNode;
            newNode.prev = current;
        }
        current = newNode;
        System.out.println("\nVisited : " + url);
    }

    @Override
    public void goBackward() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("\nBack to : " + current.url);
        }else
            System.out.println("\nNo history available to go back !!");
    }

    public void goForward() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("\nForward to : " + current.url);
        }else
            System.out.println("\nNo Forward history available !!");
    }

    @Override
    public void clearHistory() {
        current = null;
    }

    public String getCurrentPage() {
        return current != null ? "\nCurrent page : " + current.url : "NO HISTORY";
    }
}
