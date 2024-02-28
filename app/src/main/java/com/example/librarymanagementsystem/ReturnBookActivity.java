package com.example.librarymanagementsystem;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.snackbar.Snackbar;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReturnBookActivity extends AppCompatActivity {

    private EditText editTextStudentId, editTextBookId, editTextReturnedDate;
    private Button btnReturnBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return_book);

        // Initialize views
        editTextStudentId = findViewById(R.id.editTextStudentId);
        editTextBookId = findViewById(R.id.editTextBookId);
        editTextReturnedDate = findViewById(R.id.editTextReturnedDatee);
        btnReturnBook = findViewById(R.id.btnReturnBookk);

        // Set up MaterialDatePicker for Returned Date
        MaterialDatePicker<Long> datePickerBuilderReturnedDate = MaterialDatePicker.Builder.datePicker().build();
        datePickerBuilderReturnedDate.addOnPositiveButtonClickListener(selection -> {
            updateSelectedDate(editTextReturnedDate, selection);
        });

        // Show MaterialDatePicker when Returned Date EditText is clicked
        editTextReturnedDate.setOnClickListener(v -> datePickerBuilderReturnedDate.show(getSupportFragmentManager(), datePickerBuilderReturnedDate.toString()));

        // Handle the "Return Book" button click
        btnReturnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve data from the input fields
                String studentId = editTextStudentId.getText().toString();
                String bookId = editTextBookId.getText().toString();
                String returnedDate = editTextReturnedDate.getText().toString();

                // Validate the data
                if (validateData(studentId, bookId, returnedDate)) {
                    // Perform the book returning logic (e.g., update database)
                    // For demonstration purposes, we'll just display a success message
                    String successMessage = "Book successfully returned by Student ID: " + studentId +
                            "\nBook ID: " + bookId +
                            "\nReturned Date: " + returnedDate;
                    IssuedBooksManager.getInstance().removeIssuedBook(studentId, bookId);
                    showReturnInfoDialog(successMessage);
                } else {
                    // Display an error message if validation fails
                    showToast("Please fill in all the fields and select a valid returned date.");
                }
            }
        });
    }

    // Helper method to validate the input data
    private boolean validateData(String studentId, String bookId, String returnedDate) {
        // You can add more sophisticated validation logic here
        return !studentId.isEmpty() && !bookId.isEmpty() && !returnedDate.isEmpty();
    }

    // Helper method to show a toast message
    private void showToast(String message) {
        Toast.makeText(ReturnBookActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    // Helper method to update the selected date in the EditText
    private void updateSelectedDate(EditText editText, Long selection) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
        editText.setText(dateFormatter.format(new Date(selection)));
    }

    // Helper method to show the Return Information Dialog
    private void showReturnInfoDialog(String message) {
        ReturnInfoDialog returnInfoDialog = new ReturnInfoDialog(ReturnBookActivity.this, message);
        returnInfoDialog.show();
    }
}