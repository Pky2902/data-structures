package librarymanagement;

import java.util.Stack;

public class ReturnStack {
    private Stack<Book> returnStack = new Stack<>();

    public void returnBook(Book book) {
        returnStack.push(book);
    }

    public void processReturn() {
        if (!returnStack.isEmpty()) {
            Book book = returnStack.pop();
            System.out.println("Processing return for: " + book);
        } else {
            System.out.println("No returns to process.");
        }
    }
}
