package com.example.librarymanagementsystem;

public class IssuedBook {
    private String studentId;
    private String bookId;
    private String fromDate;
    private String toDate;

    public IssuedBook(String studentId, String bookId, String fromDate, String toDate) {
        this.studentId = studentId;
        this.bookId = bookId;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getBookId() {
        return bookId;
    }

    public String getFromDate() {
        return fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    // Add setter methods if needed
}
