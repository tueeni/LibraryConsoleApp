package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String URL = "jdbc:postgresql://localhost:5432/Library";
    private static final String USER = "postgres";
    private static final String PASSWORD = "pass";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void addBook(Book book) throws SQLException {
        String query = "INSERT INTO books (title, author, year, isbn) VALUES (?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setInt(3, book.getYear());
            statement.setString(4, book.getIsbn());
            statement.executeUpdate();
        }
    }

    public static void removeBook(String isbn) throws SQLException {
        String query = "DELETE FROM books WHERE isbn = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, isbn);
            statement.executeUpdate();
        }
    }

    public static List<Book> searchBooks(String title, String author, Integer year) throws SQLException {
        StringBuilder query = new StringBuilder("SELECT * FROM books WHERE 1=1");
        List<Object> parameters = new ArrayList<>();
        if (title != null) {
            query.append(" AND LOWER(title) LIKE LOWER(?)");
            parameters.add("%" + title + "%");
        }
        if (author != null) {
            query.append(" AND LOWER(author) LIKE LOWER(?)");
            parameters.add("%" + author + "%");
        }
        if (year != null) {
            query.append(" AND year = ?");
            parameters.add(year);
        }

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query.toString())) {
            for (int i = 0; i < parameters.size(); i++) {
                statement.setObject(i + 1, parameters.get(i));
            }
            try (ResultSet resultSet = statement.executeQuery()) {
                List<Book> books = new ArrayList<>();
                while (resultSet.next()) {
                    books.add(new Book(
                            resultSet.getString("title"),
                            resultSet.getString("author"),
                            resultSet.getInt("year"),
                            resultSet.getString("isbn")
                    ));
                }
                return books;
            }
        }
    }

    public static List<Book> getAllBooks() throws SQLException {
        String query = "SELECT * FROM books";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            List<Book> books = new ArrayList<>();
            while (resultSet.next()) {
                books.add(new Book(
                        resultSet.getString("title"),
                        resultSet.getString("author"),
                        resultSet.getInt("year"),
                        resultSet.getString("isbn")
                ));
            }
            return books;
        }
    }
}
