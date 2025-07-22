import java.util.*;

public class MusicPlayerApp {
    public static void main(String[] args) {
        MusicPlayer mp = new MusicPlayer();
        List<String> fullPlaylist = new ArrayList<>();

        String[] songs = {
                "Tunak Tunak", "Shape of You",
                "Animals", "Sugar",
                "Lahore"
        };

        for (String song : songs) {
            mp.addSong(song);
            fullPlaylist.add(song);
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("\n🎧 Now Playing: " + mp.getCurrentSong());

        while (true) {
            System.out.println("\n--------- Music Playlist ---------");
            System.out.println("1. Add a song");
            System.out.println("2. << Play previous");
            System.out.println("3. Play next >>");
            System.out.println("4. Show current song");
            System.out.println("5. View full playlist");
            System.out.println("6. Remove current song");
            System.out.println("7. Shuffle playlist");
            System.out.println("8. EXIT");
            System.out.print("Choose: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input 🚫");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter song title: ");
                    String title = sc.nextLine();
                    mp.addSong(title);
                    fullPlaylist.add(title);
                    break;
                case 2:
                    mp.playPrevious();
                    break;
                case 3:
                    mp.playNext();
                    break;
                case 4:
                    System.out.println("🎶 Now Playing: " + mp.getCurrentSong());
                    break;
                case 5:
                    System.out.println("🎵 Full Playlist:");
                    for (String song : fullPlaylist) System.out.println(song);
                    break;
                case 6:
                    mp.removeCurrent();
                    break;
                case 7:
                    mp.shuffle();
                    break;
                case 8:
                    System.out.println("Exiting Music Player... 🎼");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice 🚫 Try again!");
            }
        }
    }
}