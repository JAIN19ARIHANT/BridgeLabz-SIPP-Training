package MovieTime;

// Insertion Sort

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MovieSort {

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");

    public void insertionSort(Movie[] movies) {
        int n = movies.length;

        for (int i = 0; i < n; i++) {
            Movie key = movies[i];
            LocalTime keyTime = LocalTime.parse(key.getShowtime(), dtf);
            int j = i-1;

            while (j >= 0 && LocalTime.parse(movies[j].getShowtime(), dtf).isAfter(keyTime)) {
                movies[j+1] = movies[j];
                j--;
            }

            movies[j+1] = key;
        }
    }
}
