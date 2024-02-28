package com.example.librarymanagementsystem;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IssueBookActivity extends AppCompatActivity {

    private TextInputEditText datePickerFrom, datePickerTo;
    private TextView textViewSelectedDateFrom, textViewSelectedDateTo;
    private Button btnIssueBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue_book);

        // Initialize views
        EditText editTextStudentId = findViewById(R.id.editTextStudentId);
        EditText editTextBookId = findViewById(R.id.editTextBookId);

        datePickerFrom = findViewById(R.id.datePickerFrom);
        datePickerTo = findViewById(R.id.datePickerTo);

        TextView textViewFromDate = findViewById(R.id.textViewFromDate);
        TextView textViewToDate = findViewById(R.id.textViewToDate);

        textViewSelectedDateFrom = findViewById(R.id.textViewSelectedDateFrom);
        textViewSelectedDateTo = findViewById(R.id.textViewSelectedDateTo);

        btnIssueBook = findViewById(R.id.btnIssueBook);

        // Set up MaterialDatePicker for From Date
        MaterialDatePicker<Long> datePickerBuilderFrom = MaterialDatePicker.Builder.datePicker().build();
        datePickerBuilderFrom.addOnPositiveButtonClickListener(selection -> {
            updateSelectedDate(textViewSelectedDateFrom, selection);
            datePickerFrom.setText(formatDate(selection));
        });

        // Set up MaterialDatePicker for To Date
        MaterialDatePicker<Long> datePickerBuilderTo = MaterialDatePicker.Builder.datePicker().build();
        datePickerBuilderTo.addOnPositiveButtonClickListener(selection -> {
            updateSelectedDate(textViewSelectedDateTo, selection);
            datePickerTo.setText(formatDate(selection));
        });

        // Show MaterialDatePicker when From Date TextView is clicked
        datePickerFrom.setOnClickListener(v -> datePickerBuilderFrom.show(getSupportFragmentManager(), datePickerBuilderFrom.toString()));

        // Show MaterialDatePicker when To Date TextView is clicked
        datePickerTo.setOnClickListener(v -> datePickerBuilderTo.show(getSupportFragmentManager(), datePickerBuilderTo.toString()));

        // Handle the "Issue Book" button click
        btnIssueBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve data from the input fields
                String studentId = editTextStudentId.getText().toString();
                String bookId = editTextBookId.getText().toString();
                String fromDate = textViewSelectedDateFrom.getText().toString();
                String toDate = textViewSelectedDateTo.getText().toString();

                // Validate the data
                if (validateData(studentId, bookId, fromDate, toDate)) {
                    // Create the issue information string
                    String issueInfo = "Book successfully issued to Student ID: " + studentId +
                            "\nBook ID: " + bookId +
                            "\nFrom Date: " + fromDate +
                            "\nTo Date: " + toDate;

                    // Show the issue information in a dialog
                    IssueInfoDialog issueInfoDialog = new IssueInfoDialog(IssueBookActivity.this, issueInfo);
                    issueInfoDialog.show();
                    IssuedBook issuedBook = new IssuedBook(studentId, bookId, fromDate, toDate);
                    IssuedBooksManager.getInstance().addIssuedBook(issuedBook);
                } else {
                    // Display an error message if validation fails
                    showToast("Please fill in all the fields and select valid dates.");
                }
            }

            private void showSnackbar(String message) {
                Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).show();
            }
        });
    }

    // Helper method to validate the input data
    private boolean validateData(String studentId, String bookId, String fromDate, String toDate) {
        // You can add more sophisticated validation logic here
        return !studentId.isEmpty() && !bookId.isEmpty() && !fromDate.isEmpty() && !toDate.isEmpty();
    }

    // Helper method to show a toast message
    private void showToast(String message) {
        Toast.makeText(IssueBookActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    // Helper method to update the selected date in the TextView
    private void updateSelectedDate(TextView textView, Long selection) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
        textView.setText(dateFormatter.format(new Date(selection)));
    }

    // Helper method to format the date
    private String formatDate(Long selection) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
        return dateFormatter.format(new Date(selection));
    }
}
