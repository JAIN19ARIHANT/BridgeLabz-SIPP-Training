import java.util.*;
public class TopTrendingMovies {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
            new Movie("The Summit", 9.1, 2024),
            new Movie("Quiet Days", 8.3, 2021),
            new Movie("Neon Nights", 9.4, 2023),
            new Movie("Old Memories", 7.5, 2019),
            new Movie("Skyline", 8.9, 2022),
            new Movie("Edge of Time", 9.0, 2024),
            new Movie("Hidden Truths", 8.7, 2020),
            new Movie("Flashpoint", 9.2, 2024)
        );
        System.out.println("Top 5 Trending Movies:");
        movies.stream()
                .filter(m -> m.getRating() >= 8.0)
                .sorted(Comparator.comparingDouble(Movie::getRating).reversed()
                        .thenComparing(Comparator.comparingInt(Movie::getYear).reversed()))
                .limit(5)
                .forEach(System.out::println);
    }
    static class Movie {
        private String title;
        private double rating;
        private int year;
        public Movie(String title, double rating, int year) {
            this.title = title;
            this.rating = rating;
            this.year = year;
        }
        public String getTitle() { return title; }
        public double getRating() { return rating; }
        public int getYear() { return year; }
        public String toString() { return title + " (" + year + ") - Rating: " + rating; }
    }
}
