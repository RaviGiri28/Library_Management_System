package com.example.librarymanagementsystem;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MembershipAddedActivity extends AppCompatActivity {

    private TextView studentIdTextView, studentNameTextView, branchTextView, membershipTypeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membership_added);
        getSupportActionBar().setTitle("Membership Added");

        studentIdTextView = findViewById(R.id.textViewStudentId);
        studentNameTextView = findViewById(R.id.textViewStudentName);
        branchTextView = findViewById(R.id.textViewBranch);
        membershipTypeTextView = findViewById(R.id.textViewMembershipType);

        // Retrieve the data from the intent
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String studentId = bundle.getString("STUDENT_ID");
            String studentName = bundle.getString("STUDENT_NAME");
            String branch = bundle.getString("BRANCH");
            String membershipType = bundle.getString("MEMBERSHIP_TYPE");

            // Display the data in the text views
            studentIdTextView.setText("Student ID: " + studentId);
            studentNameTextView.setText("Student Name: " + studentName);
            branchTextView.setText("Branch: " + branch);
            membershipTypeTextView.setText("Membership Type: " + membershipType);
        }
    }
}
