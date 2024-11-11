package librarymanagement;

public class SearchTree {
    private class Node {
        Book book;
        Node left, right;

        Node(Book book) {
            this.book = book;
        }
    }

    private Node root;

    public void insertBook(Book book) {
        root = insertRec(root, book);
    }

    private Node insertRec(Node root, Book book) {
        if (root == null) {
            root = new Node(book);
            return root;
        }
        if (book.getISBN().compareTo(root.book.getISBN()) < 0) {
            root.left = insertRec(root.left, book);
        } else if (book.getISBN().compareTo(root.book.getISBN()) > 0) {
            root.right = insertRec(root.right, book);
        }
        return root;
    }

    public boolean searchBook(String ISBN) {
        return searchRec(root, ISBN) != null;
    }

    private Node searchRec(Node root, String ISBN) {
        if (root == null || root.book.getISBN().equals(ISBN)) {
            return root;
        }
        if (root.book.getISBN().compareTo(ISBN) > 0) {
            return searchRec(root.left, ISBN);
        }
        return searchRec(root.right, ISBN);
    }

    public void displayBooks() {
        inOrder(root);
    }

    private void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.book);
            inOrder(root.right);
        }
    }
}
