package com.example.librarymanagementsystem;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class IssuedBooks extends AppCompatActivity {

    private RecyclerView recyclerViewIssuedBooks;
    private IssuedBooksAdapter issuedBooksAdapter;
    private TextView noIssuedBooksTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issued_books);
        getSupportActionBar().setTitle("Issued Books");
        // Initialize views
        recyclerViewIssuedBooks = findViewById(R.id.recyclerViewIssuedBooks);
        noIssuedBooksTextView = findViewById(R.id.noIssuedBooksTextView);
        recyclerViewIssuedBooks.setLayoutManager(new LinearLayoutManager(this));

        // Retrieve issued books from IssuedBooksManager (you need to implement IssuedBooksManager)
        List<IssuedBook> issuedBooks = IssuedBooksManager.getInstance().getIssuedBooks();

        // Check if no books are issued
        if (issuedBooks.isEmpty()) {
            noIssuedBooksTextView.setVisibility(View.VISIBLE);
            recyclerViewIssuedBooks.setVisibility(View.GONE);
        } else {
            noIssuedBooksTextView.setVisibility(View.GONE);
            recyclerViewIssuedBooks.setVisibility(View.VISIBLE);

            // Initialize and set up the adapter
            issuedBooksAdapter = new IssuedBooksAdapter(issuedBooks);
            recyclerViewIssuedBooks.setAdapter(issuedBooksAdapter);
        }
    }
}
