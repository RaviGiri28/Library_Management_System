package com.example.librarymanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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


        getSupportActionBar().setTitle("Maintenance");

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
                        // Add User
                        startActivity(new Intent(MaintainenceActivity.this, AddUser.class));
                        break;
                    case 1:
                        // Add Book
                        startActivity(new Intent(MaintainenceActivity.this, AddBook.class));
                        break;
                    case 2:
                        // Update Book
                        startActivity(new Intent(MaintainenceActivity.this, DisplayAddedBooksActivity.class));
                        break;
                    case 3:
                        // Update User
                        startActivity(new Intent(MaintainenceActivity.this, UpdateUser.class));
                        break;
                    case 4:
                        // Add Membership
                        startActivity(new Intent(MaintainenceActivity.this, AddMembership.class));
                        break;
                    case 5:
                        // Update Membership
                        startActivity(new Intent(MaintainenceActivity.this, UpdateMembership.class));
                        break;
                }
            }
        });
    }
}
