package JavaConstructors.Level1;

public class Book {
    private String title;
    private String author;
    private double price;

    public Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
    }

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
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

    public static void main(String[] args) {

        Book book1 = new Book();
        System.out.println("Book 1 - Title: " + book1.getTitle() + ", Author: " + book1.getAuthor() + ", Price: " + book1.getPrice());

        Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 999);
        System.out.println("Book 2 - Title: " + book2.getTitle() + ", Author: " + book2.getAuthor() + ", Price: " + book2.getPrice());

        book1.setTitle("Java Programming");
        book1.setAuthor("John Doe");
        book1.setPrice(45.50);
        System.out.println("Book 1 Updated - Title: " + book1.getTitle() + ", Author: " + book1.getAuthor() + ", Price: " + book1.getPrice());

    }
}