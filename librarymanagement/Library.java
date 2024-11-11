package librarymanagement;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getISBN(), book);
    }

    public void removeBook(String ISBN) {
        books.remove(ISBN);
    }

    public void displayBooks() {
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }
    
    public Book getBook(String ISBN) {
        return books.get(ISBN);
    }
}
