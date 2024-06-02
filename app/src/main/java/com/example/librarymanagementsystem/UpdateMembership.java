package com.example.librarymanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class UpdateMembership extends AppCompatActivity {

    private EditText editTextFullNameUpdate;
    private EditText editTextUsernameUpdate;
    private EditText editTextEmailUpdate;
    private AppCompatButton btnUpdateUser;
    private TextView dropdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_membership);
        getSupportActionBar().setTitle("Update Membership");

        // Initialize Views
        editTextFullNameUpdate = findViewById(R.id.editTextFullNameUpdate);
        editTextUsernameUpdate = findViewById(R.id.editTextUsernameUpdate);
        editTextEmailUpdate = findViewById(R.id.editTextEmailUpdate);
        btnUpdateUser = findViewById(R.id.btnUpdateUser);
        dropdown = findViewById(R.id.dropdown);

        // Set Click Listener for Update Button
        btnUpdateUser.setOnClickListener(view -> updateUser());

        // Set Click Listener for Dropdown
        dropdown.setOnClickListener(v -> showPopupMenu(v));
    }

    // Method to handle Update Button Click
    private void updateUser() {
        // Get updated details
        String fullName = editTextFullNameUpdate.getText().toString().trim();
        String username = editTextUsernameUpdate.getText().toString().trim();
        String email = editTextEmailUpdate.getText().toString().trim();
        String membershipType = dropdown.getText().toString().trim();

        if (fullName.isEmpty() || username.isEmpty() || email.isEmpty() || membershipType.isEmpty()) {
            Toast.makeText(this, "Please fill out all the fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Perform Validation Here if needed

        // Pass the updated details to the UpdatedDetailsActivity
        Intent intent = new Intent(this, UpdatedMembershipDetails.class);
        intent.putExtra("FULL_NAME", fullName);
        intent.putExtra("USERNAME", username);
        intent.putExtra("EMAIL", email);
        intent.putExtra("MEMBERSHIP_TYPE", membershipType);
        startActivity(intent);
    }

    private void showPopupMenu(android.view.View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.dropdown_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(item -> {
            dropdown.setText(item.getTitle());
            return true;
        });

        popupMenu.show();
    }
}
