package com.example.librarymanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class UpdatedMembershipDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updated_membership_details);
        getSupportActionBar().setTitle("Updated Membership Details");

        String fullName = getIntent().getStringExtra("FULL_NAME");
        String username = getIntent().getStringExtra("USERNAME");
        String email = getIntent().getStringExtra("EMAIL");
        String membershipType = getIntent().getStringExtra("MEMBERSHIP_TYPE");

        // Display updated details
        TextView textViewFullName = findViewById(R.id.textViewFullName);
        TextView textViewUsername = findViewById(R.id.textViewUsername);
        TextView textViewEmail = findViewById(R.id.textViewEmail);
        TextView textViewMembershipType = findViewById(R.id.textViewMembershipType);

        textViewFullName.setText(fullName);
        textViewUsername.setText(username);
        textViewEmail.setText(email);
        textViewMembershipType.setText(membershipType);
    }
}
