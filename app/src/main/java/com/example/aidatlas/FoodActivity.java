package com.example.aidatlas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FoodActivity extends AppCompatActivity {
    TextView tv2,tv5;
    Button b1,b4;
    int mealsCount = 0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv5 = (TextView) findViewById(R.id.tv5);
        b1 = (Button) findViewById(R.id.b1);
        b4= (Button) findViewById(R.id.b4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mealsCount++;
                updatemealsCount();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String donationInfo = "Donation Details:\n";
                if (mealsCount > 0) {
                    donationInfo += "meals: " + mealsCount + "\n";
                }

                // Display donation information

                Toast.makeText(getApplicationContext(), donationInfo, Toast.LENGTH_LONG).show();

                // Show a dialog to thank for the donation
                showDialog(donationInfo);
            }
        });
    }
    // Update meals count text view
    private void updatemealsCount() {
        tv5.setText(String.valueOf(mealsCount));
    }

    private void showDialog(final String donationInfo) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Thanks for making a donation!")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        dialog.dismiss();
                        // Start NotificationActivity with donation information
                        Intent intent = new Intent(FoodActivity.this, NotificationActivity.class);
                        intent.putExtra("donationInfo", donationInfo);
                        startActivity(intent);
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}