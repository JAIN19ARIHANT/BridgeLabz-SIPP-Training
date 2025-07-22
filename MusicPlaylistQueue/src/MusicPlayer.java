import java.util.*;

public class MusicPlayer extends MediaPlayer {
    private SongNode head;
    private SongNode current;

    @Override
    void addSong(String title) {
        SongNode newSong = new SongNode(title);
        if (head == null) {
            head = newSong;
            current = head;
        } else {
            current.next = newSong;
            newSong.prev = current;
            current = newSong;
        }
        System.out.println("Title: " + newSong.title + " added.");
    }

    @Override
    void playNext() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Now playing: " + current.title);
        } else {
            System.out.println("No next song");
        }
    }

    @Override
    void playPrevious() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Now playing: " + current.title);
        } else {
            System.out.println("No previous song");
        }
    }

    @Override
    void removeCurrent() {
        if (current != null) {
            System.out.println("Removing: " + current.title);
            if (current.prev != null) current.prev.next = current.next;
            if (current.next != null) current.next.prev = current.prev;
            current = current.prev != null ? current.prev : current.next;
        } else {
            System.out.println("No song");
        }
    }

    @Override
    String getCurrentSong() {
        return current != null ? current.title : "No song playing";
    }

    @Override
    void shuffle() {
        if (head == null || head.next == null) {
            System.out.println("Not enough songs to shuffle.");
            return;
        }

        List<SongNode> songList = new ArrayList<>();
        SongNode temp = head;
        while (temp != null) {
            songList.add(temp);
            temp = temp.next;
        }

        Collections.shuffle(songList);

        for (int i = 0; i < songList.size(); i++) {
            SongNode node = songList.get(i);
            node.prev = (i > 0) ? songList.get(i - 1) : null;
            node.next = (i < songList.size() - 1) ? songList.get(i + 1) : null;
        }

        head = songList.get(0);
        current = head;
        System.out.println("Playlist shuffled. Starting with: " + current.title);
    }
}