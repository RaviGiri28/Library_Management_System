package com.example.librarymanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class User_home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        // Get product details from the Intent
        String productDetails = getIntent().getStringExtra("productDetails");

        // Display product details in a table
        displayProductDetails(productDetails);
    }

    private void displayProductDetails(String productDetails) {
        TableLayout tableLayout = findViewById(R.id.tableLayout);

        // Split the product details into rows
        String[] rows = productDetails.split("\n");

        for (String row : rows) {
            TableRow tableRow = new TableRow(this);

            // Split each row into columns
            String[] columns = row.split("\t");

            for (String column : columns) {
                TextView textView = new TextView(this);
                textView.setText(column);
                textView.setPadding(16, 16, 16, 16);
                tableRow.addView(textView);
            }

            tableLayout.addView(tableRow);
        }
    }
}
