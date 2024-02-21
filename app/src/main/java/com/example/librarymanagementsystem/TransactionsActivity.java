package com.example.librarymanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TransactionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);
        getSupportActionBar().setTitle("Transactions/");
        String[] TransactionOptions = {"Check Book Availability", "Issue a Book", "Return a Book"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.list_item_library_operation_txt, // Use the custom layout
                R.id.textLibraryOperation,
                TransactionOptions
        );
        ListView listView = findViewById(R.id.listViewLibraryOperations);
        listView.setAdapter(adapter);

        // Set item click listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Handle item clicks here
                switch (position) {
                    case 0:
                        // Check Book Availability

                        startActivity(new Intent(TransactionsActivity.this, CheckAvailabilityActivity.class));
                        break;
                    case 1:
                        // Issue a Book

                        startActivity(new Intent(TransactionsActivity.this, IssueBookActivity.class));
                        break;
                    case 2:
                        // Return a Book
                        startActivity(new Intent(TransactionsActivity.this, ReturnBookActivity.class));
                        break;
                }
            }
        });
    }
}
