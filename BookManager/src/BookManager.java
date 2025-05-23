import java.util.ArrayList;
import java.util.Scanner;

// Book class
class Book {
    private String title;
    private String author;
    private String isbn;

    // Constructor
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    // Override toString for easy printing
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn;
    }
}

// Main class to manage the collection
public class BookManager {
    private static ArrayList<Book> collection = new ArrayList<>();

    // Add book
    public static void addBook(String title, String author, String isbn) {
        Book book = new Book(title, author, isbn);
        collection.add(book);
        System.out.println("Book added: " + book);
    }

    // Remove book by ISBN
    public static void removeBook(String isbn) {
        for (Book book : collection) {
            if (book.getIsbn().equals(isbn)) {
                collection.remove(book);
                System.out.println("Book removed: " + book);
                return;
            }
        }
        System.out.println("Book with ISBN " + isbn + " not found.");
    }

    // List all books
    public static void listBooks() {
        if (collection.isEmpty()) {
            System.out.println("No books in the collection.");
        } else {
            System.out.println("Books in collection:");
            for (Book book : collection) {
                System.out.println(book);
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Book Manager ---");
            System.out.println("1. Add book");
            System.out.println("2. Remove book");
            System.out.println("3. List books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt(); scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();

                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();

                    addBook(title, author, isbn);
                    break;

                case 2:
                    System.out.print("Enter ISBN of book to remove: ");
                    String removeIsbn = scanner.nextLine();
                    removeBook(removeIsbn);
                    break;

                case 3:
                    listBooks();
                    break;

                case 4:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
