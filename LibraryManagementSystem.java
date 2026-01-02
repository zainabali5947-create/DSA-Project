package dsalabprjct;

import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add New Book");
            System.out.println("2. Edit Book Information");
            System.out.println("3. Delete Book");
            System.out.println("4. Search for a Book");
            System.out.println("5. Display All Books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Adding New Book:");
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    Book newBook = new Book(title, author, isbn, year);
                    library.addBook(newBook);
                    System.out.println("Book added successfully!");
                    break;
                case 2:
                    System.out.println("Editing Book Information:");
                    System.out.print("Enter ISBN of book to edit: ");
                    String editIsbn = scanner.nextLine();
                    Book editedBook = library.searchBook(editIsbn);
                    if (editedBook != null) {
                        System.out.println("Enter updated information:");
                        System.out.print("Enter title: ");
                        editedBook.setTitle(scanner.nextLine());
                        System.out.print("Enter author: ");
                        editedBook.setAuthor(scanner.nextLine());
                        System.out.print("Enter year: ");
                        editedBook.setYear(scanner.nextInt());
                        scanner.nextLine();
                        library.editBook(editIsbn, editedBook);
                        System.out.println("Book information updated successfully!");
                    } else {
                        System.out.println("Book not found!");
                    }
                    break;
                case 3:
                    System.out.println("Deleting Book:");
                    System.out.print("Enter ISBN of book to delete: ");
                    String deleteIsbn = scanner.nextLine();
                    library.deleteBook(deleteIsbn);
                    System.out.println("Book deleted successfully!");
                    break;
                case 4:
                    System.out.println("Searching for a Book:");
                    System.out.print("Enter ISBN of book to search: ");
                    String searchIsbn = scanner.nextLine();
                    Book foundBook = library.searchBook(searchIsbn);
                    if (foundBook != null) {
                        System.out.println("Book found:");
                        System.out.println(foundBook);
                    } else {
                        System.out.println("Book not found!");
                    }
                    break;
                case 5:
                    System.out.println("Displaying All Books:");
                    library.displayAllBooks();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}

