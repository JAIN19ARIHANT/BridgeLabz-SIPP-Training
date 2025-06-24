package JavaConstructors.Level1;

public class Library {
    private String title;
    private String author;
    private double price;
    private boolean isAvailable;

    public Library(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = true;
    }

    public boolean borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        } else {
            return false;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public static void main(String[] args) {

        Library book1 = new Library("The Java Handbook", "Code Master", 1499);
        System.out.println("Book 1 - Title: " + book1.getTitle() + ", Author: " + book1.getAuthor() + ", Price: " + book1.getPrice() + ", Available: " + book1.isAvailable());

        System.out.println("Attempting to borrow Book 1...");
        if (book1.borrowBook()) {
            System.out.println("Book 1 borrowed successfully. Available: " + book1.isAvailable());
        } else {
            System.out.println("Book 1 is not available for borrowing. Available: " + book1.isAvailable());
        }

        System.out.println("Attempting to borrow Book 1 again...");
        if (book1.borrowBook()) {
            System.out.println("Book 1 borrowed successfully. Available: " + book1.isAvailable());
        } else {
            System.out.println("Book 1 is not available for borrowing. Available: " + book1.isAvailable());
        }

        book1.setAvailable(true);
        System.out.println("Book 1 returned. Available: " + book1.isAvailable());

        Library book2 = new Library("Algorithms Unveiled", "Data Scientist", 2499);
        System.out.println("Book 2 - Title: " + book2.getTitle() + ", Author: " + book2.getAuthor() + ", Price: " + book2.getPrice() + ", Available: " + book2.isAvailable());

    }
}