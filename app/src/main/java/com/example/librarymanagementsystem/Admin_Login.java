package com.example.librarymanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
                // Get the entered username and password
                String enteredUsername = usernameEditText.getText().toString().trim();
                String enteredPassword = passwordEditText.getText().toString().trim();
                // Check if the entered username and password match the predefined values
                if (enteredUsername.equals("adm") && enteredPassword.equals("adm")) {
                    // Successful login, navigate to the next screen
                    Intent intent = new Intent(Admin_Login.this, Admin_home.class);
                    Toast.makeText(Admin_Login.this,"Login Successfull",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    finish();
                } else {
                    // Invalid credentials, show a toast message
                    Toast.makeText(Admin_Login.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}