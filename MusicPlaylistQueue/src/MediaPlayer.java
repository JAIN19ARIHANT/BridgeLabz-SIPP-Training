public abstract class MediaPlayer {
    abstract void addSong(String title);
    abstract void playNext();
    abstract void playPrevious();
    abstract void removeCurrent();
    abstract String getCurrentSong();
    abstract void shuffle();
}