package com.example.librarymanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class User_Login extends AppCompatActivity {
    private EditText usernameEdit, passwordEdit;
    private Button loginButtonUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        usernameEdit = findViewById(R.id.usernameuser);
        passwordEdit = findViewById(R.id.passworduser);
        loginButtonUser = findViewById(R.id.LogInbtnuser);

        loginButtonUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredUsername = usernameEdit.getText().toString().trim();
                Log.d("User_Login", "Entered Username: " + enteredUsername);

                String enteredPassword = passwordEdit.getText().toString().trim();

                if ("user".equals(enteredUsername) && "user".equals(enteredPassword)) {
                    String categoryCode = enteredUsername.trim().substring(0, 2).toUpperCase();
                    Log.d("User_Login", "Category Code: " + categoryCode);

                    ProductDetails productDetails = ProductDetailRepository.getProductDetailsForUser(categoryCode);

                    // Create an Intent to navigate to UserHomeActivity
                    Intent intent = new Intent(User_Login.this, User_home.class);

                    // Prepare the product details string to send to UserHomeActivity
                    String details = (productDetails != null)
                            ? "Code No From\tCode No To\tCategory\n" +
                            "SC(B/M)000001\tSC(B/M)000004\t" + productDetails.getCategory()
                            : "N/A\tN/A\tN/A\tProduct details not found";


                    // Put the product details into the Intent
                    intent.putExtra("productDetails", details);

                    // Show a toast message
                    Toast.makeText(User_Login.this, "Login Successful", Toast.LENGTH_SHORT).show();

                    // Start the UserHomeActivity
                    startActivity(intent);

                    // Finish the current activity
                    finish();
                } else {
                    // Show a toast message for invalid credentials
                    Toast.makeText(User_Login.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}