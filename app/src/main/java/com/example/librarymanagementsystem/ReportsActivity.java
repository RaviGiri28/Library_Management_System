package com.example.librarymanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ReportsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);
        String[] TransactionOptions = {"Active Issues", "Master List of Membership", "Master list of Movies","Master list of Books", "Overdue Returns","Pending issues Requests"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.list_item_library_operation_txt, // Use the custom layout
                R.id.textLibraryOperation,
                TransactionOptions
        );
        ListView listView = findViewById(R.id.listViewOperations);
        listView.setAdapter(adapter);

        // Set item click listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Handle item clicks here
                switch (position) {
                    case 0:
                        // Activity Issues

                        startActivity(new Intent(ReportsActivity.this, ActiveIssues.class));
                        break;
                    case 1:
                        // MasterListofMembership

                        startActivity(new Intent(ReportsActivity.this, MasterListofMembership.class));
                        break;
                    case 2:
                        // MasterlistofMovies
                        startActivity(new Intent(ReportsActivity.this, MasterlistofMovies.class));
                        break;
                    case 3:
                        // MasterlistofBooks
                        startActivity(new Intent(ReportsActivity.this, MasterlistofBooks.class));
                        break;
                    case 4:
                        // OverdueReturns
                        startActivity(new Intent(ReportsActivity.this, OverdueReturns.class));
                        break;
                    case 5:
                        // PendingissuesRequests
                        startActivity(new Intent(ReportsActivity.this, PendingissuesRequests.class));
                        break;
                }
            }
        });
    }
}
