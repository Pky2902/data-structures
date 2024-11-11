package librarymanagement;

import java.util.Scanner;

public class LibraryManagementSystem {
    private Library library = new Library();
    private BorrowQueue borrowQueue = new BorrowQueue();
    private ReturnStack returnStack = new ReturnStack();
    private SearchTree searchTree = new SearchTree();

    public void displayMenu() {
        System.out.println("Library Management System");
        System.out.println("1. Manage Library");
        System.out.println("2. Borrow a Book");
        System.out.println("3. Return a Book");
        System.out.println("4. Search a Book");
        System.out.println("5. Exit");
    }

    public void execute(int choice) {
        Scanner scanner = new Scanner(System.in);
        switch (choice) {
            case 1:
                System.out.println("Manage Library");
                System.out.println("1. Add Book");
                System.out.println("2. Remove Book");
                System.out.println("3. Display Books");
                int manageChoice = scanner.nextInt();
                manageLibrary(manageChoice, scanner);
                break;
            case 2:
                System.out.println("Borrow a Book");
                System.out.println("Enter ISBN:");
                String borrowISBN = scanner.next();
                Book borrowBook = library.getBook(borrowISBN);
                if (borrowBook != null) {
                    borrowQueue.borrowBook(borrowBook);
                    System.out.println("Book borrowed: " + borrowBook);
                } else {
                    System.out.println("Book not found.");
                }
                break;
            case 3:
                System.out.println("Return a Book");
                System.out.println("Enter ISBN:");
                String returnISBN = scanner.next();
                Book returnBook = library.getBook(returnISBN);
                if (returnBook != null) {
                    returnStack.returnBook(returnBook);
                    System.out.println("Book returned: " + returnBook);
                } else {
                    System.out.println("Book not found.");
                }
                break;
            case 4:
                System.out.println("Search a Book");
                System.out.println("Enter ISBN:");
                String searchISBN = scanner.next();
                if (searchTree.searchBook(searchISBN)) {
                    System.out.println("Book found: " + searchTree.searchRec(searchTree.getRoot(), searchISBN).book);
                } else {
                    System.out.println("Book not found.");
                }
                break;
            case 5:
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public void manageLibrary(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                System.out.println("Add Book");
                System.out.println("Enter title:");
                String title = scanner.next();
                System.out.println("Enter author:");
                String author = scanner.next();
                System.out.println("Enter ISBN:");
                String ISBN = scanner.next();
                Book newBook = new Book(title, author, ISBN);
                library.addBook(newBook);
                searchTree.insertBook(newBook);
                System.out.println("Book added: " + newBook);
                break;
            case 2:
                System.out.println("Remove Book");
                System.out.println("Enter ISBN:");
                String removeISBN = scanner.next();
                library.removeBook(removeISBN);
                System.out.println("Book removed with ISBN: " + removeISBN);
                break;
            case 3:
                System.out.println("Display Books");
                library.displayBooks();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystem lms = new LibraryManagementSystem();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            lms.displayMenu();
            int choice = scanner.nextInt();
            lms.execute(choice);
        }
    }
}
