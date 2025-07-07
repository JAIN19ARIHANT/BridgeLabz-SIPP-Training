import java.util.Scanner;

class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    Book prev, next;

    public Book(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.prev = this.next = null;
    }
}

public class LibraryManagementSystem {
    private Book head = null, tail = null;

    public void addAtBeginning(Book newBook) {
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    public void addAtEnd(Book newBook) {
        if (tail == null) {
            addAtBeginning(newBook);
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    public void addAtPosition(Book newBook, int position) {
        if (position <= 1 || head == null) {
            addAtBeginning(newBook);
            return;
        }

        Book current = head;
        for (int i = 1; i < position - 1 && current.next != null; i++) {
            current = current.next;
        }

        if (current.next == null) {
            addAtEnd(newBook);
        } else {
            newBook.next = current.next;
            newBook.prev = current;
            current.next.prev = newBook;
            current.next = newBook;
        }
    }

    public void removeById(int id) {
        Book current = head;

        while (current != null && current.bookId != id) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Book not found.");
            return;
        }

        if (current == head) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
        } else if (current == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        System.out.println("Book removed.");
    }

    public void search(String title, String author) {
        Book current = head;
        boolean found = false;

        while (current != null) {
            if ((title != null && current.title.equalsIgnoreCase(title)) ||
                    (author != null && current.author.equalsIgnoreCase(author))) {
                printBook(current);
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }

    public void updateAvailability(int id, boolean status) {
        Book current = head;

        while (current != null) {
            if (current.bookId == id) {
                current.isAvailable = status;
                System.out.println("Availability updated.");
                return;
            }
            current = current.next;
        }

        System.out.println("Book not found.");
    }

    public void displayForward() {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }

        Book current = head;
        System.out.println("Books (Forward):");
        while (current != null) {
            printBook(current);
            current = current.next;
        }
    }

    public void displayReverse() {
        if (tail == null) {
            System.out.println("Library is empty.");
            return;
        }

        Book current = tail;
        System.out.println("Books (Reverse):");
        while (current != null) {
            printBook(current);
            current = current.prev;
        }
    }

    public void countBooks() {
        int count = 0;
        Book current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        System.out.println("Total books in library : " + count);
    }

    private void printBook(Book b) {
        System.out.println("ID : " + b.bookId + ", Title : " + b.title + ", Author : " + b.author +
                ", Genre : " + b.genre + ", Available : " + (b.isAvailable ? " Yes" : " No"));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryManagementSystem lms = new LibraryManagementSystem();

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book at Beginning");
            System.out.println("2. Add Book at End");
            System.out.println("3. Add Book at Position");
            System.out.println("4. Remove Book by ID");
            System.out.println("5. Search Book by Title or Author");
            System.out.println("6. Update Availability");
            System.out.println("7. Display Books (Forward)");
            System.out.println("8. Display Books (Reverse)");
            System.out.println("9. Count Total Books");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt(); sc.nextLine();

            String title, author, genre;
            int id, pos;
            boolean avail;

            switch (ch) {
                case 1: case 2: case 3:
                    System.out.print("Enter Book ID: ");
                    id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Title: ");
                    title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    author = sc.nextLine();
                    System.out.print("Enter Genre: ");
                    genre = sc.nextLine();
                    System.out.print("Is Available (true/false): ");
                    avail = sc.nextBoolean();
                    Book newBook = new Book(title, author, genre, id, avail);
                    if (ch == 1) lms.addAtBeginning(newBook);
                    else if (ch == 2) lms.addAtEnd(newBook);
                    else {
                        System.out.print("Enter Position: ");
                        pos = sc.nextInt();
                        lms.addAtPosition(newBook, pos);
                    }
                    break;

                case 4:
                    System.out.print("Enter Book ID to remove: ");
                    id = sc.nextInt();
                    lms.removeById(id);
                    break;

                case 5:
                    System.out.print("Enter Title (or press Enter to skip): ");
                    title = sc.nextLine();
                    System.out.print("Enter Author (or press Enter to skip): ");
                    author = sc.nextLine();
                    lms.search(title.isEmpty() ? null : title, author.isEmpty() ? null : author);
                    break;

                case 6:
                    System.out.print("Enter Book ID: ");
                    id = sc.nextInt();
                    System.out.print("Enter New Availability (true/false): ");
                    avail = sc.nextBoolean();
                    lms.updateAvailability(id, avail);
                    break;

                case 7:
                    lms.displayForward();
                    break;

                case 8:
                    lms.displayReverse();
                    break;

                case 9:
                    lms.countBooks();
                    break;

                case 10:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
