package com.example.librarymanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class AddUser extends AppCompatActivity {

    private EditText editTextFullName, editTextUsername, editTextEmail;
    private Button btnAddUser;
    private CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        getSupportActionBar().setTitle("Add User");

        // Initialize views
        editTextFullName = findViewById(R.id.editTextFullName);
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextEmail = findViewById(R.id.editTextEmail);
        btnAddUser = findViewById(R.id.btnAddUser);
        cardView = findViewById(R.id.cardView);

        // Set onClickListener for the Add User button
        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle adding user logic here
                addUser();
            }
        });
    }

    private void addUser() {
        // Retrieve user input
        String fullName = editTextFullName.getText().toString().trim();
        String username = editTextUsername.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();

        // Validate user input
        if (fullName.isEmpty() || username.isEmpty() || email.isEmpty()) {
            // Show warning if any field is empty
            Toast.makeText(this, "All fields are required!", Toast.LENGTH_SHORT).show();
            return; // Do not proceed if validation fails
        }

        // Perform user addition (add your addition logic)

        // For this example, just show a toast message
        Toast.makeText(this, "User added successfully!", Toast.LENGTH_SHORT).show();

        // Clear the EditText fields
        editTextFullName.setText("");
        editTextUsername.setText("");
        editTextEmail.setText("");

        // Start the new activity to display added user details
        Intent intent = new Intent(AddUser.this, DisplayUserDetailsActivity.class);
        intent.putExtra("FULL_NAME", fullName);
        intent.putExtra("USERNAME", username);
        intent.putExtra("EMAIL", email);
        startActivity(intent);
    }
}
