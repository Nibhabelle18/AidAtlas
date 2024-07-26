package com.example.aidatlas;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class NotificationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        // Retrieve donation information from intent extras
        String donationInfo = getIntent().getStringExtra("donationInfo");

        // Display the donation information in a TextView
        TextView textView = findViewById(R.id.textView);
        textView.setText("Thanks for making a donation!\n\n" + donationInfo);
    }
}