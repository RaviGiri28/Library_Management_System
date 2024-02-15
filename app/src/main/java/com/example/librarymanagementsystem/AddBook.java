package com.example.librarymanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddBook extends AppCompatActivity {

    private EditText titleEditText, authorEditText, isbnEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        titleEditText = findViewById(R.id.titleEditText);
        authorEditText = findViewById(R.id.authorEditText);
        isbnEditText = findViewById(R.id.isbnEditText);

        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the book details
                String title = titleEditText.getText().toString();
                String author = authorEditText.getText().toString();
                String isbn = isbnEditText.getText().toString();

                // Create a new Book instance using the constructor
                Book newBook = new Book(title, author, isbn);

                // Save the book details in BookManager
                BookManager.getInstance().addBook(newBook);

                // Show a toast message
                Toast.makeText(AddBook.this, "Book added successfully", Toast.LENGTH_SHORT).show();

                // Navigate to DisplayBooksActivity to view the added books
                startActivity(new Intent(AddBook.this, DisplayBooksActivity.class));

                // Clear the input fields
                titleEditText.getText().clear();
                authorEditText.getText().clear();
                isbnEditText.getText().clear();
            }
        });
    }
}