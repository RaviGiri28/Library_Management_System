package com.example.librarymanagementsystem;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ConnectivityChangeReceiver connectivityChangeReceiver;
    private boolean isInternetConnected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (!isInternetConnected()) {
            // Show a message to the user indicating that internet connection is required
            Toast.makeText(this, "Please turn on the internet connection", Toast.LENGTH_LONG).show();

            // You can periodically check for internet connection and proceed when available
            startConnectivityChangeReceiver();
            checkForInternetAndProceed();
        } else {
            // If there's an internet connection, proceed after a delay
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    proceedToNextActivity();
                }
            }, 2000); // 2000 milliseconds delay
        }
    }

    private boolean isInternetConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    private void startConnectivityChangeReceiver() {
        connectivityChangeReceiver = new ConnectivityChangeReceiver();
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(connectivityChangeReceiver, intentFilter);
    }

    private void proceedToNextActivity() {
        Intent intent = new Intent(MainActivity.this, Choose_pannell.class);
        startActivity(intent);
        finish();
    }

    private void checkForInternetAndProceed() {
        if (isInternetConnected) {
            proceedToNextActivity();
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Continue checking if the internet connection is not available
                    checkForInternetAndProceed();
                }
            }, 5000); // 5000 milliseconds delay
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Unregister the receiver to avoid memory leaks
        if (connectivityChangeReceiver != null) {
            unregisterReceiver(connectivityChangeReceiver);
        }
    }

    public class ConnectivityChangeReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (isInternetConnected()) {
                isInternetConnected = true;
                // If the internet connection is now available, proceed
                checkForInternetAndProceed();
            }
        }
    }
}
