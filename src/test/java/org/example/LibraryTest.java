package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LibraryTest {
    private Library library;

    @BeforeEach
    public void setUp() {
        library = new Library();
    }

    @Test
    public void testAddBook() {
        Book book = new Book("Title", "Author", 2021, "1234567890");
        library.addBook(book);
        Assertions.assertTrue(library.getAllBooks().contains(book));
    }

    @Test
    public void testRemoveBook() {
        Book book = new Book("Title", "Author", 2021, "1234567890");
        library.addBook(book);
        library.removeBook("1234567890");
        Assertions.assertFalse(library.getAllBooks().contains(book));
    }

    @Test
    public void testSearchBooks() {
        Book book1 = new Book("Title1", "Author1", 2021, "1234567890");
        Book book2 = new Book("Title2", "Author2", 2020, "0987654321");
        library.addBook(book1);
        library.addBook(book2);

        List<Book> results = library.searchBooks("Title1", null, null);
        Assertions.assertEquals(1, results.size());
        Assertions.assertTrue(results.contains(book1));
    }
}
