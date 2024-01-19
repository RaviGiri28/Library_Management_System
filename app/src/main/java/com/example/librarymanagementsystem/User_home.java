package com.example.librarymanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
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

        // Add main header row for categories
        TableRow mainHeaderRow = new TableRow(this);

        // Display "Product Details"
        TextView mainHeaderDetails = new TextView(this);
        mainHeaderDetails.setText("Product Details");
        mainHeaderDetails.setPadding(16, 16, 16, 16);
        mainHeaderDetails.setGravity(Gravity.CENTER); // Center the text horizontally
        mainHeaderDetails.setBackgroundColor(Color.parseColor("#CCCCCC")); // Set background color
        mainHeaderDetails.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18); // Set text size
        mainHeaderDetails.setTypeface(null, Typeface.BOLD); // Set text style
        mainHeaderRow.addView(mainHeaderDetails);

        mainHeaderRow.setGravity(Gravity.CENTER_HORIZONTAL); // Center the TableRow horizontally
        tableLayout.addView(mainHeaderRow);

        // Add header row for categories
        TableRow headerRow = new TableRow(this);

        // Display "Code No From"
        TextView headerFrom = new TextView(this);
        headerFrom.setText("Code No From");
        headerFrom.setPadding(16, 16, 16, 16);
        headerFrom.setBackgroundColor(Color.parseColor("#CCCCCC")); // Set background color
        headerRow.addView(headerFrom);

        // Display "Code No To"
        TextView headerTo = new TextView(this);
        headerTo.setText("Code No To");
        headerTo.setPadding(16, 16, 16, 16);
        headerTo.setBackgroundColor(Color.parseColor("#CCCCCC")); // Set background color
        headerRow.addView(headerTo);

        // Display "Category"
        TextView headerCategory = new TextView(this);
        headerCategory.setText("Category");
        headerCategory.setPadding(16, 16, 16, 16);
        headerCategory.setBackgroundColor(Color.parseColor("#CCCCCC")); // Set background color
        headerRow.addView(headerCategory);

        // Display "Product Details"
        TextView headerDetails = new TextView(this);
        headerDetails.setText("Details");
        headerDetails.setPadding(16, 16, 16, 16);
        headerDetails.setBackgroundColor(Color.parseColor("#CCCCCC")); // Set background color
        headerRow.addView(headerDetails);

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

                // Display "Product Details"
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
