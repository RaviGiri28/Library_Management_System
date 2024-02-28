package com.example.librarymanagementsystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IssuedBooksManager {
    private static final IssuedBooksManager instance = new IssuedBooksManager();
    private List<IssuedBook> issuedBooks;

    private IssuedBooksManager() {
        issuedBooks = new ArrayList<>();
    }

    public static IssuedBooksManager getInstance() {
        return instance;
    }

    public List<IssuedBook> getIssuedBooks() {
        return issuedBooks;
    }

    public void addIssuedBook(IssuedBook issuedBook) {
        issuedBooks.add(issuedBook);
    }

    public void removeIssuedBook(String studentId, String bookId) {
        Iterator<IssuedBook> iterator = issuedBooks.iterator();
        while (iterator.hasNext()) {
            IssuedBook issuedBook = iterator.next();
            if (issuedBook.getStudentId().equals(studentId) && issuedBook.getBookId().equals(bookId)) {
                iterator.remove();
                break;
            }
        }
    }
}
