package com.example.librarymanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin_Login extends AppCompatActivity {
    private EditText usernameEditText, passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        usernameEditText=findViewById(R.id.username);
        passwordEditText=findViewById(R.id.password);
        loginButton=findViewById(R.id.LogInbtn);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredUsername = usernameEditText.getText().toString().trim();
                Log.d("Admin_Login", "Entered Username: " + enteredUsername);

                String enteredPassword = passwordEditText.getText().toString().trim();

                if ("adm".equals(enteredUsername) && "adm".equals(enteredPassword)) {
                    String categoryCode = enteredUsername.trim().substring(0, 2).toUpperCase();
                    Log.d("Admin_Login", "Category Code: " + categoryCode);

                    ProductDetails productDetails = ProductDetailRepository.getProductDetailsForUser(categoryCode);

                    // Create an Intent to navigate to UserHomeActivity
                    Intent intent = new Intent(Admin_Login.this, Admin_home.class);

                    // Prepare the product details string to send to UserHomeActivity
                    String details = (productDetails != null)
                            ? "Code No From\tCode No To\tCategory\n" +
                            "SC(B/M)000001\tSC(B/M)000004\t" + productDetails.getCategory()
                            : "N/A\tN/A\tN/A\tProduct details not found";


                    // Put the product details into the Intent
                    intent.putExtra("productDetails", details);

                    // Show a toast message
                    Toast.makeText(Admin_Login.this, "Login Successful", Toast.LENGTH_SHORT).show();

                    // Start the UserHomeActivity
                    startActivity(intent);

                    // Finish the current activity
                    finish();
                } else {
                    // Show a toast message for invalid credentials
                    Toast.makeText(Admin_Login.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}