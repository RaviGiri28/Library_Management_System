package com.example.librarymanagementsystem;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class DisplayBooksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_books);
        getSupportActionBar().setTitle("Books");

        displayBooks();
    }

    private void displayBooks() {
        List<Book> bookList = BookManager.getInstance().getBooks();

        StringBuilder displayText = new StringBuilder();

        for (Book book : bookList) {
            // Display book details
            displayText.append("Title: ").append(book.getTitle()).append("\n");
            displayText.append("Author: ").append(book.getAuthor()).append("\n");
            displayText.append("ISBN: ").append(book.getIsbn()).append("\n\n");
        }

        // Display the books in a TextView
        TextView bookTextView = findViewById(R.id.bookTextView);
        bookTextView.setText(displayText.toString());
    }

}
