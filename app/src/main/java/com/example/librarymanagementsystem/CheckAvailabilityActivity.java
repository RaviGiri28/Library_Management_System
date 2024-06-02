package com.example.librarymanagementsystem;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CheckAvailabilityActivity extends AppCompatActivity {

    private EditText searchEditText;
    private RecyclerView recyclerView;
    private TextView noResultsTextView;
    private Spinner filterSpinner;
    private AppCompatButton applyFilterButton;

    private List<Book> dummyBooks;
    private List<Book> filteredBooks;
    private BookAdapter bookAdapter;
    private ArrayAdapter<String> spinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_availability);
        getSupportActionBar().setTitle("Check Book Availability");

        // Initialize views
        searchEditText = findViewById(R.id.searchEditText);
        recyclerView = findViewById(R.id.recyclerView);
        noResultsTextView = findViewById(R.id.noResultsTextView);
        filterSpinner = findViewById(R.id.filterSpinner);
        applyFilterButton = findViewById(R.id.applyFilterButton);

        recyclerView.setVisibility(View.GONE);

        // Initialize dummy books
        dummyBooks = new ArrayList<>();
        dummyBooks.add(new Book("Physics", " D K Bhattacharya", "Ph56342"));
        dummyBooks.add(new Book("Computer Organization Architecture", "William Stallings", "COA8932"));
        dummyBooks.add(new Book("Data Structure Algorithm", "Leiserson, Ronald L. Rivest", "DSA2396"));
        dummyBooks.add(new Book("Mathematics", "Dr. M.V.S.S.N. Prasad", "MTH5438"));
        dummyBooks.add(new Book("Design and analysis of algorithms", "PRABHAKAR GUPTA", "MTH5438"));
        // Add more dummy books if needed

        // Set up RecyclerView
        filteredBooks = new ArrayList<>();
        bookAdapter = new BookAdapter(filteredBooks, new BookAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                // Handle item click if needed
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(bookAdapter);

        // Set up Spinner
        List<String> bookTitles = new ArrayList<>();
        bookTitles.add("Select Category"); // Add "Select Category" as the first item
        for (Book book : dummyBooks) {
            bookTitles.add(book.getTitle());
        }
        spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, bookTitles);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filterSpinner.setAdapter(spinnerAdapter);

        // Set the default selection to "Select Category"
        filterSpinner.setSelection(0);

        // Set up Filter Button click listener
        applyFilterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyFilter();
            }
        });

        // Set up TextChangedListener for searchEditText
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                applyFilter(); // Apply filter whenever text changes
            }
        });
    }

    private void applyFilter() {
        String selectedBookTitle = (String) filterSpinner.getSelectedItem();
        String searchTerm = searchEditText.getText().toString().trim();

        // Check if the search term is empty and the filter spinner is set to "Select Category"
        if (searchTerm.isEmpty() && "Select Category".equals(selectedBookTitle)) {
            recyclerView.setVisibility(View.GONE); // Hide RecyclerView
            noResultsTextView.setVisibility(View.GONE); // Hide "No Books Available" message
            return; // No need to update filter
        }

        // Filter books based on the selected book title and/or search term
        filteredBooks.clear();
        for (Book book : dummyBooks) {
            if (("Select Category".equals(selectedBookTitle) || book.getTitle().equalsIgnoreCase(selectedBookTitle))
                    && (searchTerm.isEmpty() || book.getTitle().toLowerCase().contains(searchTerm.toLowerCase()))) {
                filteredBooks.add(book);
            }
        }

        if (!filteredBooks.isEmpty()) {
            bookAdapter.updateDataset(filteredBooks); // Update RecyclerView with filtered books
            recyclerView.setVisibility(View.VISIBLE); // Show RecyclerView
            noResultsTextView.setVisibility(View.GONE); // Hide "No Books Available" message
        } else {
            recyclerView.setVisibility(View.GONE); // Hide RecyclerView
            noResultsTextView.setVisibility(View.VISIBLE); // Show "No Books Available" message
            noResultsTextView.setText("No Books Available"); // Set message to "No Books Available"
        }
    }
}