package org.example;

import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LibraryApp {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            try {
                printMenu();
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        addBook();
                        break;
                    case 2:
                        removeBook();
                        break;
                    case 3:
                        searchBooks();
                        break;
                    case 4:
                        listBooks();
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                scanner.next();
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    private static void printMenu() {
        System.out.println("Choose an option:");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. Search Books");
        System.out.println("4. List All Books");
        System.out.println("5. Exit");
    }

    private static void addBook() {
        try {
            System.out.println("Enter title:");
            String title = scanner.nextLine();
            System.out.println("Enter author:");
            String author = scanner.nextLine();
            System.out.println("Enter year:");
            int year = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter ISBN:");
            String isbn = scanner.nextLine();

            Book book = new Book(title, author, year, isbn);
            library.addBook(book);
            System.out.println("Book added: " + book);
        } catch (NumberFormatException e) {
            System.out.println("Invalid year format. Please enter a valid year.");
        } catch (Exception e) {
            System.out.println("An error occurred while adding the book: " + e.getMessage());
        }
    }

    private static void removeBook() {
        try {
            System.out.println("Enter ISBN of the book to remove:");
            String isbn = scanner.nextLine();
            library.removeBook(isbn);
            System.out.println("Book removed (if it existed).");
        } catch (NoSuchElementException e) {
            System.out.println("No book found with the given ISBN.");
        } catch (Exception e) {
            System.out.println("An error occurred while removing the book: " + e.getMessage());
        }
    }

    private static void searchBooks() {
        try {
            System.out.println("Enter title (or leave blank):");
            String title = scanner.nextLine().trim();
            title = title.isEmpty() ? null : title;

            System.out.println("Enter author (or leave blank):");
            String author = scanner.nextLine().trim();
            author = author.isEmpty() ? null : author;

            System.out.println("Enter year (or leave blank):");
            String yearInput = scanner.nextLine().trim();
            Integer year = yearInput.isEmpty() ? null : Integer.parseInt(yearInput);

            List<Book> results = library.searchBooks(title, author, year);
            if (results.isEmpty()) {
                System.out.println("No books found.");
            } else {
                results.forEach(System.out::println);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid year format. Please enter a valid year.");
        } catch (Exception e) {
            System.out.println("An error occurred while searching for books: " + e.getMessage());
        }
    }

    private static void listBooks() {
        try {
            List<Book> books = library.getAllBooks();
            if (books.isEmpty()) {
                System.out.println("No books in the library.");
            } else {
                books.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("An error occurred while listing the books: " + e.getMessage());
        }
    }
}
