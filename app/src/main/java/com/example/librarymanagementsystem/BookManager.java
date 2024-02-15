package com.example.librarymanagementsystem;
import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private static final BookManager instance = new BookManager();
    private List<Book> books;

    private BookManager() {
        books = new ArrayList<>();
    }

    public static BookManager getInstance() {
        return instance;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void updateBook(int position, String updatedTitle, String updatedAuthor, String updatedIsbn) {
        Book updatedBook = books.get(position);
        updatedBook.setTitle(updatedTitle);
        updatedBook.setAuthor(updatedAuthor);
        updatedBook.setIsbn(updatedIsbn);
    }
}
