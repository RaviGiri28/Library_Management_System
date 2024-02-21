package com.example.librarymanagementsystem;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateBook extends AppCompatActivity {

    private EditText updateTitleEditText;
    private EditText updateAuthorEditText;
    private EditText updateIsbnEditText;
    private int bookPosition;
    private BookAdapter bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_book);
        getSupportActionBar().setTitle("Update Book");
        updateTitleEditText = findViewById(R.id.updateTitleEditText);
        updateAuthorEditText = findViewById(R.id.updateAuthorEditText);
        updateIsbnEditText = findViewById(R.id.updateIsbnEditText);

        // Retrieve the book position from the intent
        bookPosition = getIntent().getIntExtra("bookPosition", -1);

        if (bookPosition != -1) {
            // Get the selected book
            Book selectedBook = BookManager.getInstance().getBooks().get(bookPosition);

            // Display current details in EditText fields
            updateTitleEditText.setText(selectedBook.getTitle());
            updateAuthorEditText.setText(selectedBook.getAuthor());
            updateIsbnEditText.setText(selectedBook.getIsbn());
        }

        Button updateButton = findViewById(R.id.updateButton);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the updated book details
                String updatedTitle = updateTitleEditText.getText().toString();
                String updatedAuthor = updateAuthorEditText.getText().toString();
                String updatedIsbn = updateIsbnEditText.getText().toString();

                // Update the book details
                updateBook(bookPosition, updatedTitle, updatedAuthor, updatedIsbn);

                if (bookAdapter != null) {
                    bookAdapter.updateDataset(BookManager.getInstance().getBooks());
                }
                // Finish the activity
                finish();
            }
        });
    }

    private void updateBook(int position, String updatedTitle, String updatedAuthor, String updatedIsbn) {
        // Update the book details in BookManager
        BookManager.getInstance().updateBook(position, updatedTitle, updatedAuthor, updatedIsbn);
    }

    public void setBookAdapter(BookAdapter adapter) {
        this.bookAdapter = adapter;
    }
}
