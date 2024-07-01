package org.example;

import java.sql.SQLException;
import java.util.List;

public class Library {

    public void addBook(Book book) {
        try {
            DatabaseManager.addBook(book);
        } catch (SQLException e) {
            System.out.println("Error adding book: " + e.getMessage());
        }
    }

    public void removeBook(String isbn) {
        try {
            DatabaseManager.removeBook(isbn);
        } catch (SQLException e) {
            System.out.println("Error removing book: " + e.getMessage());
        }
    }

    public List<Book> searchBooks(String title, String author, Integer year) {
        try {
            return DatabaseManager.searchBooks(title, author, year);
        } catch (SQLException e) {
            System.out.println("Error searching books: " + e.getMessage());
            return null;
        }
    }

    public List<Book> getAllBooks() {
        try {
            return DatabaseManager.getAllBooks();
        } catch (SQLException e) {
            System.out.println("Error retrieving all books: " + e.getMessage());
            return null;
        }
    }
}
