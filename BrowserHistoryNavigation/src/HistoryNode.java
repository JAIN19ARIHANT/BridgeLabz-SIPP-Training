public class HistoryNode {
    String url;
    HistoryNode next,prev;

    public HistoryNode (String url) {
        this.url = url;
    }

    public HistoryNode() {
    }
}
