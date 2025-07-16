package BookShelf;

import java.util.*;

public class BookShelf {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Library library = new Library();

        library.addBook("Action",new Book("Iron Man","Stan Lee","001"));
        library.addBook("Shonen",new Book("One Piece","Eiichiro Oda","002"));
        library.addBook("Non-fiction",new Book("Surrounded by Idiots","Thomas Erikson","003"));
        library.addBook("fantasy",new Book("Harry Potter","J.K. Rowling","004"));

//        library.printGenre("Shonen");

        while (true) {
            System.out.println("\n----------Library----------");
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. Search by Genre");
            System.out.println("4. Exit");

            int n = sc.nextInt();
            sc.nextLine();

            switch (n) {
                case 1 :
                    System.out.print("\nEnter genre of book : ");
                    String bookGenre = sc.nextLine();
                    System.out.print("\nEnter book title : ");
                    String bookName = sc.nextLine();
                    System.out.print("\nAuthor of book : ");
                    String bookAuthor = sc.nextLine();
                    System.out.print("\nEnter book ID : ");
                    String bookID = sc.next();

                    library.addBook(bookGenre,new Book(bookName,bookAuthor,bookID));

                    break;

                case 2 :
                    System.out.print("\nEnter genre of book : ");
                    String bookGen = sc.nextLine();
                    System.out.print("\nEnter book ID : ");
                    String bookId = sc.next();

                    library.removeBook(bookGen,bookId);

                    break;

                case 3 :
                    System.out.print("\nEnter genre of book : ");
                    String genBook = sc.nextLine();

                    library.printGenre(genBook);

                    break;

                case 4 :
                    System.exit(0);

                default:
                    System.out.println("❌ Wrong input !! ❌");
            }
        }
    }
}
