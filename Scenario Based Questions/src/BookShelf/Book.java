package BookShelf;

import java.util.Objects;

public class Book {
    String title;
    String author;
    String id;

    public Book (String title, String author, String id) {
        this.title = title;
        this.author = author;
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
