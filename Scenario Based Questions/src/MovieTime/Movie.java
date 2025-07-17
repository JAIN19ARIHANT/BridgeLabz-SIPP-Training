package MovieTime;

public class Movie {
    private String name;
    private String genre;
    private String showtime;

    public Movie (String name, String genre, String showtime) {
        this.name = name;
        this.genre = genre;
        this.showtime = showtime;
    }

    public void setName(String name) { this.name  = name; }

    public void setGenre(String genre) { this.genre = genre; }

    public void setShowtime(String showtime) {this.showtime = showtime; }

    public String getName() { return name; }

    public String getGenre() { return genre; }

    public String getShowtime() {return showtime; }

    @Override
    public String toString() {
        return name + " - " + showtime;
    }
}
