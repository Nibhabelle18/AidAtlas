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

public class SanitaryActivity extends AppCompatActivity {
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7;
    Button b1,b2,b3,b4;
    int padsCount = 0, tamponsCount = 0, intimateCount = 0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sanitary);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        tv5 = (TextView) findViewById(R.id.tv5);
        tv6 = (TextView) findViewById(R.id.tv6);
        tv7 = (TextView) findViewById(R.id.tv7);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                padsCount++;
                updatePadsCount();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tamponsCount++;
                updateTamponsCount();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intimateCount++;
                updateIntimateCount();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String donationInfo = "Donation Details:\n";
                if (padsCount > 0) {
                    donationInfo += "Pads: " + padsCount + "\n";
                }
                if (tamponsCount > 0) {
                    donationInfo += "Tampons: " + tamponsCount + "\n";
                }
                if (intimateCount > 0) {
                    donationInfo += "Intimate Cleaning Products: " + intimateCount + "\n";
                }

                // Display donation information

                Toast.makeText(getApplicationContext(), donationInfo, Toast.LENGTH_LONG).show();

                // Show a dialog to thank for the donation
                showDialog(donationInfo);
            }
        });
    }
        // Update Pads count text view
        private void updatePadsCount() {
            tv5.setText(String.valueOf(padsCount));
        }

        // Update Tampons count text view
        private void updateTamponsCount() {
            tv6.setText(String.valueOf(tamponsCount));
        }

        // Update Intimate Cleaning Products count text view
        private void updateIntimateCount() {
            tv7.setText(String.valueOf(intimateCount));
        }
    private void showDialog(final String donationInfo) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Thanks for making a donation!")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        dialog.dismiss();
                        // Start NotificationActivity with donation information
                        Intent intent = new Intent(SanitaryActivity.this, NotificationActivity.class);
                        intent.putExtra("donationInfo", donationInfo);
                        startActivity(intent);
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}