package com.example.librarymanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class UpdateUser extends AppCompatActivity {

    private EditText editTextFullNameUpdate, editTextUsernameUpdate, editTextEmailUpdate;
    private Button btnUpdateUser;
    private CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);
        getSupportActionBar().setTitle("Update User");

        // Initialize views
        editTextFullNameUpdate = findViewById(R.id.editTextFullNameUpdate);
        editTextUsernameUpdate = findViewById(R.id.editTextUsernameUpdate);
        editTextEmailUpdate = findViewById(R.id.editTextEmailUpdate);
        btnUpdateUser = findViewById(R.id.btnUpdateUser);
        cardView = findViewById(R.id.cardView);

        // Retrieve existing user details from intent
        Intent intent = getIntent();
        if (intent != null) {
            String fullName = intent.getStringExtra("FULL_NAME");
            String username = intent.getStringExtra("USERNAME");
            String email = intent.getStringExtra("EMAIL");

            // Set existing user details in EditText for modification
            editTextFullNameUpdate.setText(fullName);
            editTextUsernameUpdate.setText(username);
            editTextEmailUpdate.setText(email);
        }

        // Set onClickListener for the Update User button
        btnUpdateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle updating user logic here
                updateUser();
            }
        });
    }

    private void updateUser() {
        // Retrieve modified user input
        String fullName = editTextFullNameUpdate.getText().toString().trim();
        String username = editTextUsernameUpdate.getText().toString().trim();
        String email = editTextEmailUpdate.getText().toString().trim();

        // Validate user input
        if (fullName.isEmpty() || username.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "All fields are required!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Perform user update (add your update logic)

        // For this example, just show a toast message
        Toast.makeText(this, "User updated successfully!", Toast.LENGTH_SHORT).show();

        // Clear the EditText fields
        editTextFullNameUpdate.setText("");
        editTextUsernameUpdate.setText("");
        editTextEmailUpdate.setText("");

        // Start the new activity to display updated user details
        Intent intent = new Intent(UpdateUser.this, DisplayUserDetailsActivity.class);
        intent.putExtra("FULL_NAME", fullName);
        intent.putExtra("USERNAME", username);
        intent.putExtra("EMAIL", email);
        startActivity(intent);
    }
}
