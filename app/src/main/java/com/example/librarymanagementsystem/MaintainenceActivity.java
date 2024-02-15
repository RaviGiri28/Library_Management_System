package com.example.librarymanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MaintainenceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintainence);
        String[] TransactionOptions = {"Add User", "Add Book","Update Book", "Update User","Add Membership","Update Membership"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.list_item_library_operation_txt, // Use the custom layout
                R.id.textLibraryOperation,
                TransactionOptions
        );
        ListView listView = findViewById(R.id.listViewLibraryOperations2);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Handle item clicks here
                switch (position) {
                    case 0:
                        // Check Book Availability

                        startActivity(new Intent(MaintainenceActivity.this, AddUser.class));
                        break;
                    case 1:
                        // Issue a Book

                        startActivity(new Intent(MaintainenceActivity.this, AddBook.class));
                        break;
                    case 2:
                        // Return a Book
                        startActivity(new Intent(MaintainenceActivity.this, DisplayAddedBooksActivity.class));
                        break;
                    case 3:
                        // Issue a Book

                        startActivity(new Intent(MaintainenceActivity.this, UpdateUser.class));
                        break;
                    case 4:
                        // Issue a Book

                        startActivity(new Intent(MaintainenceActivity.this, AddMembership.class));
                        break;
                    case 5:
                        // Issue a Book

                        startActivity(new Intent(MaintainenceActivity.this, UpdateMembership.class));
                        break;
                }
            }
        });
    }
}
