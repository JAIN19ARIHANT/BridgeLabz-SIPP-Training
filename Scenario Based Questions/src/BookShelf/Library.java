package BookShelf;

import java.util.*;

public class Library {
    Map<String, LinkedList<Book>> map = new HashMap<>();

    Set<String> bookSet = new HashSet<>();

    public void addBook(String genre, Book book) {

        if (bookSet.contains(book.id))
            return;

        map.putIfAbsent(genre,new LinkedList<>());
        map.get(genre).add(book);
        bookSet.add(book.id);
    }

    public void removeBook(String genre, String bookId) {
        LinkedList<Book> list = map.get(genre);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                Book b = list.get(i);
                if (b.id != null && b.id.compareTo(bookId) == 0) {
                    list.remove(i);
                    bookSet.remove(bookId);
                    break;
                }
            }
        }
    }

    public void printGenre(String genre) {
        LinkedList<Book> list = null;

        for (String key : map.keySet()) {
            if (key != null && key.equalsIgnoreCase(genre)) {
                list = map.get(key);
                break;
            }
        }

        if (list != null) {
            int i = 1;
            for (Book b : list) {
                System.out.println(i++ + ". " + b.title + " by " + b.author);
            }
        } else {
            System.out.println("No book in this genre");
        }
    }

}
