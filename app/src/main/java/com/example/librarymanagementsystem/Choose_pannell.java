package com.example.librarymanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Choose_pannell extends AppCompatActivity {
    Button Adminbtn, Userbtn;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_pannell);
        Adminbtn = findViewById(R.id.adminbtn);
        Userbtn = findViewById(R.id.userbtn);
        img = findViewById(R.id.boygirlimg);
        Userbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Choose_pannell.this, User_Login.class);
                startActivity(intent);
                finish();
            }
        });
        Adminbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Assuming Admin_Login is the correct activity name
                Intent intent = new Intent(Choose_pannell.this, Admin_Login.class);
                startActivity(intent);
                // Commenting out finish() to allow navigation back from Admin_Login if needed
                // finish();
            }
        });
    }
}
