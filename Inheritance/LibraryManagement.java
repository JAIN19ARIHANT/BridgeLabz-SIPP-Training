public class LibraryManagement {
    public static void main(String[] args) {
        Author bookWithAuthor = new Author(
                "Surrounded by Idiots",
                2014,
                "Thomas Erikson",
                "A Swedish behaviorist and bestselling author known for simplifying human communication using the DISC color model."
        );

        bookWithAuthor.displayInfo();
    }
}

class Book {
    String title;
    int publicationYear;

    Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

class Author extends Book {
    String name;
    String bio;

    Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Author Name: " + name);
        System.out.println("Author Bio: " + bio);
    }
}

