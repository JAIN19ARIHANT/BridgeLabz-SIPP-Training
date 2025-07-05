import java.util.*;

interface Reservable {
    void reserveItem(String borrower);
    boolean checkAvailability();
}

abstract class LibraryItem implements Reservable {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    private int itemId;
    private String title;
    private String author;
    private boolean isReserved = false;
    private String borrower;

    LibraryItem (int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public abstract int getLoanDuration();

    public String getItemDetails() {
        return "ID : " + itemId + "\nTitle : " + title + "\nAuthor : " + author;
    }

    public String getBorrower() {
        return borrower;
    }

    @Override
    public void reserveItem(String borrower) {
        if (!isReserved) {
            isReserved = true;
            this.borrower = borrower;
            System.out.println(title + " is issued to : " + borrower);
        }
        else {
            System.out.println(RED + title + " is not available for issue !" + RESET);
        }
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved;
    }
}

class Book extends LibraryItem {
    public Book (int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public boolean checkAvailability() {
        return super.checkAvailability();
    }

    @Override
    public int getLoanDuration() {
        return 14;
    }
}

class Magazine extends LibraryItem {
    public Magazine (int itemId, String title, String author) {
        super(itemId,title,author);
    }

    @Override
    public boolean checkAvailability() {
        return super.checkAvailability();
    }

    @Override
    public int getLoanDuration() {
        return 7;
    }
}

class DVD extends LibraryItem {
    DVD (int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public boolean checkAvailability() {
        return super.checkAvailability();
    }

    @Override
    public int getLoanDuration() {
        return 3;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        List<LibraryItem> list = new ArrayList<>();

        list.add(new Book(1,"Surrounded by Idiots","Thomas Erikson"));
        list.add(new Magazine(7,"Forbes 40 under 40","Forbes Global Media Holdings Inc."));
        list.add(new Magazine(2,"Bloomberg Businessweek","Bloomberg L.P."));
        list.add(new DVD(60,"F1","Brad Pitt"));

        for (LibraryItem i : list) {
            System.out.println("\n" + i.getItemDetails());
            System.out.println("Loan Duration : " + i.getLoanDuration() + " Days");
            i.reserveItem("Arihant");
            if (i.checkAvailability())
                System.out.println(LibraryItem.GREEN + "Availability : " + i.checkAvailability() + LibraryItem.RESET);
            else
                System.out.println(LibraryItem.RED + "Availability : " + i.checkAvailability() + LibraryItem.RESET);
            System.out.println("-------------------------");
        }
    }
}