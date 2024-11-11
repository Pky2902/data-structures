package librarymanagement;

import java.util.LinkedList;
import java.util.Queue;

public class BorrowQueue {
    private Queue<Book> borrowQueue = new LinkedList<>();

    public void borrowBook(Book book) {
        borrowQueue.add(book);
    }

    public void processBookRequest() {
        Book book = borrowQueue.poll();
        if (book != null) {
            System.out.println("Processing borrow request for: " + book);
        } else {
            System.out.println("No borrow requests in queue.");
        }
    }

    public void reserveBook(Book book) {
        borrowQueue.add(book);
    }
}
