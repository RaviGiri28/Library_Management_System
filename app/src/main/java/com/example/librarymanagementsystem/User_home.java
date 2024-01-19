package com.example.librarymanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Map;

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

        // Display the main header
        TableRow headerRow = new TableRow(this);

        // Display "Code No From" header
        TextView codeFromHeaderTextView = new TextView(this);
        codeFromHeaderTextView.setText("Code No From");
        codeFromHeaderTextView.setPadding(16, 16, 16, 16);
        headerRow.addView(codeFromHeaderTextView);

        // Display "Code No To" header
        TextView codeToHeaderTextView = new TextView(this);
        codeToHeaderTextView.setText("Code No To");
        codeToHeaderTextView.setPadding(16, 16, 16, 16);
        headerRow.addView(codeToHeaderTextView);

        // Display "Category" header
        TextView categoryHeaderTextView = new TextView(this);
        categoryHeaderTextView.setText("Category");
        categoryHeaderTextView.setPadding(16, 16, 16, 16);
        headerRow.addView(categoryHeaderTextView);

        // Display "Details" header
        TextView detailsHeaderTextView = new TextView(this);
        detailsHeaderTextView.setText("Details");
        detailsHeaderTextView.setPadding(16, 16, 16, 16);
        headerRow.addView(detailsHeaderTextView);

        tableLayout.addView(headerRow);

        // Check if product details are not found
        if (productDetails.equals("N/A\tN/A\tN/A\tProduct details not found")) {
            TextView notFoundTextView = new TextView(this);
            notFoundTextView.setText("Product details not found");
            notFoundTextView.setPadding(16, 16, 16, 16);
            tableLayout.addView(notFoundTextView);
        } else {
            // Display the first 5 rows from the product repository
            int count = 0;
            for (Map.Entry<String, ProductDetails> entry : ProductDetailRepository.productDetailsMap.entrySet()) {
                TableRow tableRow = new TableRow(this);

                // Display "Code No From"
                TextView codeFromTextView = new TextView(this);
                codeFromTextView.setText(entry.getKey() + "(B/M)000001");
                codeFromTextView.setPadding(16, 16, 16, 16);
                tableRow.addView(codeFromTextView);

                // Display "Code No To"
                TextView codeToTextView = new TextView(this);
                codeToTextView.setText(entry.getKey() + "(B/M)000004");
                codeToTextView.setPadding(16, 16, 16, 16);
                tableRow.addView(codeToTextView);

                // Display "Category"
                TextView categoryTextView = new TextView(this);
                categoryTextView.setText(entry.getValue().getCategory());
                categoryTextView.setPadding(16, 16, 16, 16);
                tableRow.addView(categoryTextView);

                // Display "Details"
                TextView detailsTextView = new TextView(this);
                detailsTextView.setText(entry.getValue().getDetails());
                detailsTextView.setPadding(16, 16, 16, 16);
                tableRow.addView(detailsTextView);

                tableLayout.addView(tableRow);

                count++;

                // Break the loop when 5 rows are displayed
                if (count >= 5) {
                    break;
                }
            }
        }
    }
}