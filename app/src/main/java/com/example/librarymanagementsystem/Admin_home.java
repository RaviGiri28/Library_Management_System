package com.example.librarymanagementsystem;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Map;

public class Admin_home extends AppCompatActivity {
    private EditText searchEditText2;
    private BottomNavigationView bottomNavigationView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        getSupportActionBar().setTitle("Admin Pannel");

        // Get product details from the Intent
        String productDetails = getIntent().getStringExtra("productDetails");

        // Display product details in a table
      //  displayProductDetails(productDetails);
        searchEditText2 = findViewById(R.id.searchEditText2);
        setSearchTextWatcher();
        bottomNavigationView2 = findViewById(R.id.bottom_navigation2);
        setBottomNavigationListener();

        CardView addBookCardView = findViewById(R.id.cardView1);
        CardView addMembershipCardView = findViewById(R.id.cardView2);
        CardView issueBookCardView = findViewById(R.id.cardView3);
        CardView checkBookAvailability = findViewById(R.id.cardView4);

        checkBookAvailability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start AddBookActivity
                Intent addBookIntent = new Intent(Admin_home.this, CheckAvailabilityActivity.class);
                startActivity(addBookIntent);
            }
        });

        issueBookCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start AddBookActivity
                Intent addBookIntent = new Intent(Admin_home.this, IssueBookActivity.class);
                startActivity(addBookIntent);
            }
        });

        addMembershipCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start AddBookActivity
                Intent addBookIntent = new Intent(Admin_home.this, AddMembership.class);
                startActivity(addBookIntent);
            }
        });
        addBookCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start AddBookActivity
                Intent addBookIntent = new Intent(Admin_home.this, AddBook.class);
                startActivity(addBookIntent);
            }
        });
    }

    private void setSearchTextWatcher() {
        if (searchEditText2 != null) {
            searchEditText2.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void afterTextChanged(Editable editable) {
                    // Filter the products based on the search input
                   // filterProducts(editable.toString());
                }
            });
        }
    }

    private void setBottomNavigationListener() {
        if (bottomNavigationView2 != null) {
            bottomNavigationView2.setOnNavigationItemSelectedListener(item -> {
                if (item.getItemId() == R.id.navigation_transactions) {
                    Intent transactionsIntent = new Intent(Admin_home.this, TransactionsActivity.class);
                    startActivity(transactionsIntent);
                    return true;
                } else if (item.getItemId() == R.id.navigation_report) {
                    Intent ReportIntent = new Intent(Admin_home.this, ReportsActivity.class);
                    startActivity(ReportIntent);
                    return true;
                } else if (item.getItemId() == R.id.navigation_maintainence) {
                    Intent MaintainenceIntent = new Intent(Admin_home.this, MaintainenceActivity.class);
                    startActivity(MaintainenceIntent);
                }
                return false;
            });
        }
    }

//    private void filterProducts(String searchQuery) {
//        Map<String, ProductDetails> filteredProducts = ProductDetailRepository.getFilteredProducts(searchQuery);
//        clearTableLayout();
//        displayFilteredProducts(filteredProducts);
//    }

//    private void displayFilteredProducts(Map<String, ProductDetails> filteredProducts) {
//        TableLayout tableLayout = findViewById(R.id.tableLayout2);
//
//        TableRow headerRow = new TableRow(this);
//        TextView headerFrom = new TextView(this);
//        headerFrom.setText("Code No From");
//        headerFrom.setTextColor(getResources().getColor(android.R.color.white));
//        headerFrom.setPadding(16, 16, 16, 16);
//        headerFrom.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//        headerRow.addView(headerFrom);
//
//        // Display "Code No To"
//        TextView headerTo = new TextView(this);
//        headerTo.setText("Code No To");
//        headerTo.setTextColor(getResources().getColor(android.R.color.white));
//        headerTo.setPadding(16, 16, 16, 16);
//        headerTo.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//        headerRow.addView(headerTo);
//
//        // Display "Category"
//        TextView headerCategory = new TextView(this);
//        headerCategory.setText("Category");
//        headerCategory.setTextColor(getResources().getColor(android.R.color.white));
//        headerCategory.setPadding(16, 16, 16, 16);
//        headerCategory.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//        headerRow.addView(headerCategory);
//
//        // Display "Product Details"
//        TextView headerDetails = new TextView(this);
//        headerDetails.setText("Details");
//        headerDetails.setTextColor(getResources().getColor(android.R.color.black));
//        headerDetails.setPadding(16, 16, 16, 16);
//        headerDetails.setBackgroundColor(getResources().getColor(android.R.color.transparent));
//        headerRow.addView(headerDetails);
//
//        tableLayout.addView(headerRow);
//
//        // Check if products are not found
//        if (filteredProducts.isEmpty()) {
//            TextView notFoundTextView = new TextView(this);
//            notFoundTextView.setText("No matching products found");
//            notFoundTextView.setTextColor(getResources().getColor(android.R.color.black));
//            notFoundTextView.setPadding(16, 16, 16, 16);
//            notFoundTextView.setBackgroundColor(getResources().getColor(android.R.color.transparent));
//            tableLayout.addView(notFoundTextView);
//        } else {
//            // Display the filtered products
//            for (Map.Entry<String, ProductDetails> entry : filteredProducts.entrySet()) {
//                TableRow tableRow = new TableRow(this);
//                tableRow.setBackgroundResource(R.drawable.table_row_border);
//
//
//                // Display "Code No From"
//                TextView codeFromTextView = new TextView(this);
//                codeFromTextView.setText(entry.getKey() + "(B/M)000001");
//                codeFromTextView.setPadding(16, 16, 16, 16);
//                codeFromTextView.setBackgroundColor(getResources().getColor(android.R.color.transparent));
//                tableRow.addView(getHorizontalScrollView(codeFromTextView));
//
//                // Display "Code No To"
//                TextView codeToTextView = new TextView(this);
//                codeToTextView.setText(entry.getKey() + "(B/M)000004");
//                codeToTextView.setPadding(16, 16, 16, 16);
//                codeToTextView.setBackgroundColor(getResources().getColor(android.R.color.transparent));
//                tableRow.addView(getHorizontalScrollView(codeToTextView));
//
//                // Display "Category"
//                TextView categoryTextView = new TextView(this);
//                categoryTextView.setText(entry.getValue().getCategory());
//                categoryTextView.setPadding(16, 16, 16, 16);
//                categoryTextView.setBackgroundColor(getResources().getColor(android.R.color.transparent));
//                tableRow.addView(getHorizontalScrollView(categoryTextView));
//
//                // Display "Product Details"
//                TextView detailsTextView = new TextView(this);
//                detailsTextView.setText(entry.getValue().getDetails());
//                detailsTextView.setPadding(16, 16, 16, 16);
//                detailsTextView.setBackgroundColor(getResources().getColor(android.R.color.transparent));
//                tableRow.addView(getHorizontalScrollView(detailsTextView));
//
//                tableLayout.addView(tableRow);
//            }
//        }
//    }

//    private HorizontalScrollView getHorizontalScrollView(TextView textView) {
//        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(this);
//        LinearLayout linearLayout = new LinearLayout(this);
//        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
//        linearLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
//        linearLayout.addView(textView);
//        horizontalScrollView.addView(linearLayout);
//        return horizontalScrollView;
//    }

//    private void clearTableLayout() {
//        TableLayout tableLayout = findViewById(R.id.tableLayout2);
//        tableLayout.removeAllViews();
//    }

//    private void displayProductDetails(String productDetails) {
//        TableLayout tableLayout = findViewById(R.id.tableLayout2);
//
//        TableRow emptyRow = new TableRow(this);
//        emptyRow.setMinimumHeight(290);
//        tableLayout.addView(emptyRow);
//
//        // Add main header row for categories
//        TableRow mainHeaderRow = new TableRow(this);
//
//        // Display "Product Details"
//        TextView mainHeaderDetails = new TextView(this);
//        mainHeaderDetails.setText("Book Details");
//        mainHeaderDetails.setPadding(16, 16, 16, 16);
//        mainHeaderDetails.setGravity(Gravity.CENTER);
//        mainHeaderDetails.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//        mainHeaderDetails.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
//        mainHeaderDetails.setTextColor(getResources().getColor(android.R.color.white));
//        mainHeaderDetails.setTypeface(null, Typeface.BOLD);
//        mainHeaderRow.addView(mainHeaderDetails);
//
//        mainHeaderRow.setGravity(Gravity.CENTER_HORIZONTAL);
//        tableLayout.addView(mainHeaderRow);
//
//        // Add header row for categories
//        TableRow headerRow = new TableRow(this);
//
//        // Display "Code No From"
//        TextView headerFrom = new TextView(this);
//        headerFrom.setText("Code No From");
//        headerFrom.setTextColor(getResources().getColor(android.R.color.white));
//        headerFrom.setPadding(16, 16, 16, 16);
//        headerFrom.setBackgroundColor(getResources().getColor(R.color.colorPrimary)); // Set background color
//        headerRow.addView(headerFrom);

        // Display "Code No To"
//        TextView headerTo = new TextView(this);
//        headerTo.setText("Code No To");
//        headerTo.setTextColor(getResources().getColor(android.R.color.white));
//        headerTo.setPadding(16, 16, 16, 16);
//        headerTo.setBackgroundColor(getResources().getColor(R.color.colorPrimary)); // Set background color
//        headerRow.addView(headerTo);
//
//        // Display "Category"
//        TextView headerCategory = new TextView(this);
//        headerCategory.setText("Category");
//        headerCategory.setTextColor(getResources().getColor(android.R.color.white));
//        headerCategory.setPadding(16, 16, 16, 16);
//        headerCategory.setBackgroundColor(getResources().getColor(R.color.colorPrimary)); // Set background color
//        headerRow.addView(headerCategory);
//
//        // Display "Product Details"
//        TextView headerDetails = new TextView(this);
//        headerDetails.setText("Details");
//        headerDetails.setTextColor(getResources().getColor(android.R.color.white));
//        headerDetails.setPadding(16, 16, 16, 16);
//        headerDetails.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//        headerRow.addView(headerDetails);
//
//        tableLayout.addView(headerRow);
//
//        // Check if product details are not found
//        if (productDetails.equals("N/A\tN/A\tN/A\tProduct details not found")) {
//            TextView notFoundTextView = new TextView(this);
//            notFoundTextView.setText("Product details not found");
//            notFoundTextView.setTextColor(getResources().getColor(android.R.color.white));
//            notFoundTextView.setPadding(16, 16, 16, 16);
//            notFoundTextView.setBackgroundColor(getResources().getColor(android.R.color.transparent));
//            tableLayout.addView(notFoundTextView);
//        } else {
//            // Display the first 5 rows from the product repository
//            int count = 0;
//
//            for (Map.Entry<String, ProductDetails> entry : ProductDetailRepository.productDetailsMap.entrySet()) {
//                TableRow tableRow = new TableRow(this);
//                tableRow.setBackgroundResource(R.drawable.table_row_border);
//
//                // Display "Code No From"
//                TextView codeFromTextView = new TextView(this);
//                codeFromTextView.setText(entry.getKey() + "(B/M)000001");
//                codeFromTextView.setPadding(16, 16, 16, 16);
//                codeFromTextView.setBackgroundColor(getResources().getColor(android.R.color.transparent));
//                tableRow.addView(getHorizontalScrollView(codeFromTextView));
//
//                // Display "Code No To"
//                TextView codeToTextView = new TextView(this);
//                codeToTextView.setText(entry.getKey() + "(B/M)000004");
//                codeToTextView.setPadding(16, 16, 16, 16);
//                codeToTextView.setBackgroundColor(getResources().getColor(android.R.color.transparent));
//                tableRow.addView(getHorizontalScrollView(codeToTextView));
//
//                // Display "Category"
//                TextView categoryTextView = new TextView(this);
//                categoryTextView.setText(entry.getValue().getCategory());
//                categoryTextView.setPadding(16, 16, 16, 16);
//                categoryTextView.setBackgroundColor(getResources().getColor(android.R.color.transparent));
//                tableRow.addView(getHorizontalScrollView(categoryTextView));
//
//                // Display "Product Details"
//                TextView detailsTextView = new TextView(this);
//                detailsTextView.setText(entry.getValue().getDetails());
//                detailsTextView.setPadding(16, 16, 16, 16);
//                detailsTextView.setBackgroundColor(getResources().getColor(android.R.color.transparent));
//                tableRow.addView(getHorizontalScrollView(detailsTextView));
//
//                tableLayout.addView(tableRow);
//
//                count++;
//
//                // Break the loop when 5 rows are displayed
//                if (count >= 5) {
//                    break;
//                }
//            }
//        }
//    }
}
