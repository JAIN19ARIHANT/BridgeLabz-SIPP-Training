package MovieTime;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MovieTime {
    public static void main(String[] args) {

        ArrayList<Movie> moviesList = new ArrayList<>();


        Movie m0 = new Movie("Avengers","Sci-Fi","07:00");
        moviesList.add(m0);
        Movie m1 = new Movie("RRR","Action","09:40");
        moviesList.add(m1);
        Movie m2 = new Movie("MI-8","Action","12:30");
        moviesList.add(m2);
        Movie m3 = new Movie("Baahubali 2","Fiction","13:00");
        moviesList.add(m3);
        Movie m4 = new Movie("Avatar 2","Fiction","15:00");
        moviesList.add(m4);
        Movie m5 = new Movie("Dhurandar","Biopic","20:00");
        moviesList.add(m5);

        Movie[] movies = moviesList.toArray(new Movie[0]);

        MovieSort sorter = new MovieSort();

        sorter.insertionSort(movies);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime currentTime = LocalTime.now();

        System.out.println("\n\n\u001b[7mCurrent Time: " + currentTime.format(dtf) + "\u001b[0m\n");

        System.out.printf("%-20s %-15s %-10s %n", "Movie Name", "Genre", "Showtime");
        System.out.println("-------------------------------------------------------");

        for (Movie movie : movies) {
            LocalTime movieTime = LocalTime.parse(movie.getShowtime(), dtf);
            String color;

            if (movieTime.isBefore(currentTime)) {
                color = "\u001b[31m";       // RED
            } else {
                int minutesUntilStart = Math.toIntExact(Duration.between(currentTime, movieTime).toMinutes());
                color = (minutesUntilStart <= 15) ? "\u001b[34m" : "\u001b[32m";    // BLUE : GREEN
            }

            String reset = "\u001b[0m";

            System.out.printf(color + " %-20s  %-15s  %-10s " + reset + "%n",
                    movie.getName(),
                    movie.getGenre(),
                    movie.getShowtime());
        }

    }
}