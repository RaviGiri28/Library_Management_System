package com.example.librarymanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class AddMembership extends AppCompatActivity {

    private EditText editTextStudentId, editStudentName, editTextBranch;
    private TextView dropdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_membership);
        getSupportActionBar().setTitle("Add Membership");

        editTextStudentId = findViewById(R.id.editTextStudentId);
        editStudentName = findViewById(R.id.editStudentName);
        editTextBranch = findViewById(R.id.editTextBranch);
        dropdown = findViewById(R.id.dropdown);

        dropdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });

        findViewById(R.id.btnAddMember).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String studentId = editTextStudentId.getText().toString();
                String studentName = editStudentName.getText().toString();
                String branch = editTextBranch.getText().toString();
                String membershipType = dropdown.getText().toString();

                if (studentId.isEmpty() || studentName.isEmpty() || branch.isEmpty() || membershipType.isEmpty() || membershipType.equals("Choose Membership Type")) {
                    Toast.makeText(AddMembership.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Display flash message
                String message = "Membership added:\nStudent ID: " + studentId + "\nStudent Name: " + studentName + "\nBranch: " + branch + "\nMembership Type: " + membershipType;
                Snackbar snackbar = Snackbar.make(v, message, Snackbar.LENGTH_LONG);
                View snackbarView = snackbar.getView();
                TextView textView = snackbarView.findViewById(com.google.android.material.R.id.snackbar_text);
                textView.setMaxLines(5); // Adjust the number of lines to fit your content
                snackbar.show();
            }
        });
    }

    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.dropdown_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                dropdown.setText(item.getTitle());
                return true;
            }
        });

        popupMenu.show();
    }
}
