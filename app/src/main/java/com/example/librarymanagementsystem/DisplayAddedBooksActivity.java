package com.example.librarymanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DisplayAddedBooksActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BookAdapter bookAdapter;
    private TextView noBooksTextView;
    private static final int UPDATE_BOOK_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_added_books);
        getSupportActionBar().setTitle("Added Books");
        recyclerView = findViewById(R.id.recyclerView);
        noBooksTextView = findViewById(R.id.noBooksTextView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Retrieve added books from BookManager
        List<Book> addedBooks = BookManager.getInstance().getBooks();

        // Check if no books are added
        if (addedBooks.isEmpty()) {
            noBooksTextView.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            noBooksTextView.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);

            // Initialize and set up the adapter
            bookAdapter = new BookAdapter(addedBooks, new BookAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    // Handle item click (open UpdateBookActivity)
                    openUpdateBookActivity(position);
                }
            });
            recyclerView.setAdapter(bookAdapter);
        }
    }

    private void openUpdateBookActivity(int position) {
        Intent intent = new Intent(this, UpdateBook.class);
        intent.putExtra("bookPosition", position);
        startActivityForResult(intent, UPDATE_BOOK_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == UPDATE_BOOK_REQUEST) {
            // Retrieve added books from BookManager
            List<Book> addedBooks = BookManager.getInstance().getBooks();

            // Update the adapter with the new list of books
            bookAdapter.setBooks(addedBooks);
            bookAdapter.notifyDataSetChanged();

            // Check if no books are added
            if (addedBooks.isEmpty()) {
                showNoBooksMessage();
            } else {
                noBooksTextView.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
            }
        }
    }

    public void showNoBooksMessage() {
            noBooksTextView.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        }
    }



