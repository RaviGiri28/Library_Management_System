package com.example.librarymanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
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
                String enteredPassword = passwordEdit.getText().toString().trim();

                // Assume login is successful for demonstration purposes
                if ("user".equals(enteredUsername) && "user".equals(enteredPassword)) {
                    String categoryCode = enteredUsername.substring(0, 2);
                    ProductDetails productDetails = ProductDetailRepository.getProductDetailsForUser(categoryCode);

                    String details;
                    if (productDetails != null) {
                        details = "Category: " + productDetails.getCategory() + "\nDetails: " + productDetails.getDetails();
                    } else {
                        // If product details not found, display a message
                        details = "Category: N/A\nDetails: Product details not found";
                    }

                    Intent intent = new Intent(User_Login.this, User_home.class);
                    intent.putExtra("productDetails", details);

                    Toast.makeText(User_Login.this, "Login Successful", Toast.LENGTH_SHORT).show();

                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(User_Login.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
