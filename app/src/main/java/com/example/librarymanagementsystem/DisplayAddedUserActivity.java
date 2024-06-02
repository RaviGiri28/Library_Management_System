package com.example.librarymanagementsystem;

import static android.content.Intent.getIntent;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;

// In DisplayAddedUserDetailsActivity.java
public class DisplayAddedUserActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private TextView noUsersTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_added_user);
        getSupportActionBar().setTitle("Added Users");

        recyclerView = findViewById(R.id.recyclerView);
        noUsersTextView = findViewById(R.id.noUsersTextView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Retrieve added user data from SharedPreferences or another source
        SharedPreferences preferences = getSharedPreferences("USER_DETAILS", MODE_PRIVATE);
        String fullName = preferences.getString("FULL_NAME", "");
        String username = preferences.getString("USERNAME", "");
        String email = preferences.getString("EMAIL", "");

        // Create a User object with the retrieved data
        User user = new User(fullName, username, email);

        // Check if user data is available
        if (user != null) {
            // Hide the "No Users" message and display the RecyclerView
            noUsersTextView.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);

            // Initialize and set up the adapter
            userAdapter = new UserAdapter(Collections.singletonList(user));
            recyclerView.setAdapter(userAdapter);
        } else {
            // Show the "No Users" message and hide the RecyclerView
            noUsersTextView.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        }
    }
}
