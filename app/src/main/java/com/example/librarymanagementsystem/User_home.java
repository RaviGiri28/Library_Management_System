package com.example.librarymanagementsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Map;

public class User_home extends AppCompatActivity {
    private EditText searchEditText;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);


        // Get product details from the Intent
        String productDetails = getIntent().getStringExtra("productDetails");

        // Display product details in a table
        displayProductDetails(productDetails);
        searchEditText = findViewById(R.id.searchEditText);
        setSearchTextWatcher();
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        setBottomNavigationListener();
    }

    private void setSearchTextWatcher() {
        if (searchEditText != null) {
            searchEditText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void afterTextChanged(Editable editable) {
                    // Filter the products based on the search input
                    filterProducts(editable.toString());
                }
            });
        }
    }

    private void setBottomNavigationListener() {
        if (bottomNavigationView != null) {
            bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
                if (item.getItemId() == R.id.navigation_transactions) {
                    Intent transactionsIntent = new Intent(User_home.this, TransactionsActivity.class);
                    startActivity(transactionsIntent);
                    return true;
                } else if (item.getItemId()==R.id.navigation_report) {
                    Intent ReportIntent = new Intent(User_home.this, ReportsActivity.class);
                    startActivity(ReportIntent);
                    return true;
                }

                return false;
            });
        }
    }
    private void filterProducts(String searchQuery) {
        Map<String, ProductDetails> filteredProducts = ProductDetailRepository.getFilteredProducts(searchQuery);
        clearTableLayout();
        displayFilteredProducts(filteredProducts);
    }

    private void displayFilteredProducts(Map<String, ProductDetails> filteredProducts) {
        TableLayout tableLayout = findViewById(R.id.tableLayout);
        TableRow headerRow = new TableRow(this);
        TextView headerFrom = new TextView(this);
        headerFrom.setText("Code No From");
        headerFrom.setTextColor(Color.WHITE);
        headerFrom.setPadding(16, 16, 16, 16);
        headerFrom.setBackgroundColor(Color.parseColor("#CCCCCC"));
        headerRow.addView(headerFrom);

        // Display "Code No To"
        TextView headerTo = new TextView(this);
        headerTo.setText("Code No To");
        headerTo.setTextColor(Color.WHITE);
        headerTo.setPadding(16, 16, 16, 16);
        headerTo.setBackgroundColor(Color.parseColor("#CCCCCC"));
        headerRow.addView(headerTo);

        // Display "Category"
        TextView headerCategory = new TextView(this);
        headerCategory.setText("Category");
        headerCategory.setTextColor(Color.WHITE);
        headerCategory.setPadding(16, 16, 16, 16);
        headerCategory.setBackgroundColor(Color.parseColor("#CCCCCC"));
        headerRow.addView(headerCategory);

        // Display "Product Details"
        TextView headerDetails = new TextView(this);
        headerDetails.setText("Details");
        headerDetails.setTextColor(Color.WHITE);
        headerDetails.setPadding(16, 16, 16, 16);
        headerDetails.setBackgroundColor(Color.parseColor("#CCCCCC"));
        headerRow.addView(headerDetails);


        tableLayout.addView(headerRow);

        // Check if products are not found
        if (filteredProducts.isEmpty()) {
            TextView notFoundTextView = new TextView(this);
            notFoundTextView.setText("No matching products found");
            notFoundTextView.setTextColor(Color.WHITE);
            notFoundTextView.setPadding(16, 16, 16, 16);
            notFoundTextView.setBackgroundColor(Color.TRANSPARENT);
            tableLayout.addView(notFoundTextView);
        } else {
            // Display the filtered products
            for (Map.Entry<String, ProductDetails> entry : filteredProducts.entrySet()) {
                TableRow tableRow = new TableRow(this);
                tableRow.setBackgroundColor(Color.TRANSPARENT);

                // Display "Code No From"
                TextView codeFromTextView = new TextView(this);
                codeFromTextView.setText(entry.getKey() + "(B/M)000001");
                codeFromTextView.setPadding(16, 16, 16, 16);
                codeFromTextView.setBackgroundColor(Color.TRANSPARENT);
                tableRow.addView(codeFromTextView);

                // Display "Code No To"
                TextView codeToTextView = new TextView(this);
                codeToTextView.setText(entry.getKey() + "(B/M)000004");
                codeToTextView.setPadding(16, 16, 16, 16);
                codeToTextView.setBackgroundColor(Color.TRANSPARENT);
                tableRow.addView(codeToTextView);

                // Display "Category"
                TextView categoryTextView = new TextView(this);
                categoryTextView.setText(entry.getValue().getCategory());
                categoryTextView.setPadding(16, 16, 16, 16);
                categoryTextView.setBackgroundColor(Color.TRANSPARENT);
                tableRow.addView(categoryTextView);

                // Display "Product Details"
                TextView detailsTextView = new TextView(this);
                detailsTextView.setText(entry.getValue().getDetails());
                detailsTextView.setPadding(16, 16, 16, 16);
                detailsTextView.setBackgroundColor(Color.TRANSPARENT);
                tableRow.addView(detailsTextView);

                tableLayout.addView(tableRow);
            }
        }
    }


    private void clearTableLayout() {
        TableLayout tableLayout = findViewById(R.id.tableLayout);
        tableLayout.removeAllViews();
    }

    private void displayProductDetails(String productDetails) {
        TableLayout tableLayout = findViewById(R.id.tableLayout);

        TableRow emptyRow = new TableRow(this);
        emptyRow.setMinimumHeight(290);
        tableLayout.addView(emptyRow);

        // Add main header row for categories
        TableRow mainHeaderRow = new TableRow(this);

        // Display "Product Details"
        TextView mainHeaderDetails = new TextView(this);
        mainHeaderDetails.setText("Product Details");
        mainHeaderDetails.setPadding(16, 16, 16, 16);
        mainHeaderDetails.setGravity(Gravity.CENTER);
        mainHeaderDetails.setBackgroundColor(Color.parseColor("#CCCCCC"));
        mainHeaderDetails.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        mainHeaderDetails.setTextColor(Color.WHITE);
        mainHeaderDetails.setTypeface(null, Typeface.BOLD);
        mainHeaderRow.addView(mainHeaderDetails);

        mainHeaderRow.setGravity(Gravity.CENTER_HORIZONTAL);
        tableLayout.addView(mainHeaderRow);

        // Add header row for categories
        TableRow headerRow = new TableRow(this);

        // Display "Code No From"
        TextView headerFrom = new TextView(this);
        headerFrom.setText("Code No From");
        headerFrom.setTextColor(Color.WHITE);
        headerFrom.setPadding(16, 16, 16, 16);
        headerFrom.setBackgroundColor(Color.parseColor("#CCCCCC"));
        headerRow.addView(headerFrom);

        // Display "Code No To"
        TextView headerTo = new TextView(this);
        headerTo.setText("Code No To");
        headerTo.setTextColor(Color.WHITE);
        headerTo.setPadding(16, 16, 16, 16);
        headerTo.setBackgroundColor(Color.parseColor("#CCCCCC"));
        headerRow.addView(headerTo);

        // Display "Category"
        TextView headerCategory = new TextView(this);
        headerCategory.setText("Category");
        headerCategory.setTextColor(Color.WHITE);
        headerCategory.setPadding(16, 16, 16, 16);
        headerCategory.setBackgroundColor(Color.parseColor("#CCCCCC"));
        headerRow.addView(headerCategory);

        // Display "Product Details"
        TextView headerDetails = new TextView(this);
        headerDetails.setText("Details");
        headerDetails.setTextColor(Color.WHITE);
        headerDetails.setPadding(16, 16, 16, 16);
        headerDetails.setBackgroundColor(Color.parseColor("#CCCCCC"));
        headerRow.addView(headerDetails);

        tableLayout.addView(headerRow);

        if (productDetails.equals("N/A\tN/A\tN/A\tProduct details not found")) {
            TextView notFoundTextView = new TextView(this);
            notFoundTextView.setText("Product details not found");
            notFoundTextView.setTextColor(Color.WHITE);
            notFoundTextView.setPadding(16, 16, 16, 16);
            notFoundTextView.setBackgroundColor(Color.TRANSPARENT);
            tableLayout.addView(notFoundTextView);
        } else {
            // Display the first 5 rows from the product repository
            int count = 0;
            for (Map.Entry<String, ProductDetails> entry : ProductDetailRepository.productDetailsMap.entrySet()) {
                TableRow tableRow = new TableRow(this);
                tableRow.setBackgroundResource(R.drawable.table_row_border);

                // Display "Code No From"
                TextView codeFromTextView = new TextView(this);
                codeFromTextView.setText(entry.getKey() + "(B/M)000001");
                codeFromTextView.setPadding(16, 16, 16, 16);
                codeFromTextView.setBackgroundColor(Color.TRANSPARENT);
                tableRow.addView(codeFromTextView);

                // Display "Code No To"
                TextView codeToTextView = new TextView(this);
                codeToTextView.setText(entry.getKey() + "(B/M)000004");
                codeToTextView.setPadding(16, 16, 16, 16);
                codeToTextView.setBackgroundColor(Color.TRANSPARENT);
                tableRow.addView(codeToTextView);

                // Display "Category"
                TextView categoryTextView = new TextView(this);
                categoryTextView.setText(entry.getValue().getCategory());
                categoryTextView.setPadding(16, 16, 16, 16);
                categoryTextView.setBackgroundColor(Color.TRANSPARENT);
                tableRow.addView(categoryTextView);

                // Display "Product Details"
                TextView detailsTextView = new TextView(this);
                detailsTextView.setText(entry.getValue().getDetails());
                detailsTextView.setPadding(16, 16, 16, 16);
                detailsTextView.setBackgroundColor(Color.TRANSPARENT);
                tableRow.addView(detailsTextView);

                tableLayout.addView(tableRow);

                count++;


                if (count >= 5) {
                    break;
                }
            }
        }
    }
}
