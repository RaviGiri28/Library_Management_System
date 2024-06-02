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
        getSupportActionBar().setTitle("Add Book");

        titleEditText = findViewById(R.id.titleEditText);
        authorEditText = findViewById(R.id.authorEditText);
        isbnEditText = findViewById(R.id.isbnEditText);

        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the book details
                String title = titleEditText.getText().toString().trim();
                String author = authorEditText.getText().toString().trim();
                String isbn = isbnEditText.getText().toString().trim();

                // Validate the input fields
                if (title.isEmpty() || author.isEmpty() || isbn.isEmpty()) {
                    // Show a warning message if any field is empty
                    Toast.makeText(AddBook.this, "All fields are required!", Toast.LENGTH_SHORT).show();
                    return;
                }

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
