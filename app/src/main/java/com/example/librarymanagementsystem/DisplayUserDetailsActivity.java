package com.example.librarymanagementsystem;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayUserDetailsActivity extends AppCompatActivity {

    private TextView textViewFullName, textViewUsername, textViewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_user_details);
        getSupportActionBar().setTitle("User Details");

        // Initialize views
        textViewFullName = findViewById(R.id.textViewFullName);
        textViewUsername = findViewById(R.id.textViewUsername);
        textViewEmail = findViewById(R.id.textViewEmail);

        // Retrieve user details from intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String fullName = extras.getString("FULL_NAME");
            String username = extras.getString("USERNAME");
            String email = extras.getString("EMAIL");

            // Set user details to text views
            textViewFullName.setText("Full Name: " + fullName);
            textViewUsername.setText("Username: " + username);
            textViewEmail.setText("Email: " + email);
        }
    }
}
