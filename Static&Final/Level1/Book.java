package Static&Final.Level1;

public class Book {

    private static String libraryName = "GLA Central Library";
    private final String isbn;
    private String title;
    private String author;

    public static void main(String[] args) {
        System.out.println("Welcome to " + Book.libraryName);

        Book book1 = new Book("978-0321765723", "Surrounded by Idiots", "Thomas Erikson");
        Book book2 = new Book("978-0743273565", "The Great Gatsby", "F. Scott Fitzgerald");
        Book book3 = new Book("978-0439023528", "The Hunger Games", "Suzanne Collins");

        if (book1 instanceof Book) {
            System.out.println("\nChecking book1 type using instanceof:");
            book1.displayBookDetails();
        }

        if (book2 instanceof Book) {
            book2.displayBookDetails();
        }
        if (book3 instanceof Book) {
            book3.displayBookDetails();
        }

        Book.displayLibraryName();

        Object randomObject = new Integer(123);
        if (randomObject instanceof Book) {
            System.out.println("\nrandomObject is an instance of Book.");
        } else {
            System.out.println("\nrandomObject is NOT an instance of Book.");
        }
    }

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public static void displayLibraryName() {
        System.out.println("\n--- Library Information ---");
        System.out.println("Library Name: " + libraryName);
        System.out.println("-----------------------------");
    }

    public void displayBookDetails() {
        System.out.println("\n--- Book Details ---");
        System.out.println("Library: " + libraryName);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("----------------------");
    }
}