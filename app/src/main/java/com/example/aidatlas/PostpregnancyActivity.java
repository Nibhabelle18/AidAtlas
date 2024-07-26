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

public class PostpregnancyActivity extends AppCompatActivity {
    TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9;
    Button b1, b2, b3, b4, b5;
    int adultCount = 0, bottlesCount = 0, oilCount = 0, formulaCount = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postpregnancy);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        tv5 = (TextView) findViewById(R.id.tv5);
        tv6 = (TextView) findViewById(R.id.tv6);
        tv7 = (TextView) findViewById(R.id.tv7);
        tv8 = (TextView) findViewById(R.id.tv8);
        tv9 = (TextView) findViewById(R.id.tv9);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        b5 = (Button) findViewById(R.id.b5);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adultCount++;
                updateadultCount();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottlesCount++;
                updatebottlesCount();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oilCount++;
                updateoilCount();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formulaCount++;
                updateformulaCount();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String donationInfo = "Donation Details:\n";
                if (adultCount > 0) {
                    donationInfo += "Adult Diapers: " + adultCount + "\n";
                }
                if (bottlesCount > 0) {
                    donationInfo += "Baby Bottles: " + bottlesCount + "\n";
                }
                if (oilCount > 0) {
                    donationInfo += "Baby Oil: " + oilCount + "\n";
                }
                if (formulaCount > 0) {
                    donationInfo += "Baby Formula: " + formulaCount + "\n";
                }

                // Display donation information

                Toast.makeText(getApplicationContext(), donationInfo, Toast.LENGTH_LONG).show();

                // Show a dialog to thank for the donation
                showDialog(donationInfo);
            }
        });
    }

    // Update adult count text view
    private void updateadultCount() {
        tv5.setText(String.valueOf(adultCount));
    }

    // Update bottles count text view
    private void updatebottlesCount() {
        tv6.setText(String.valueOf(bottlesCount));
    }

    // Update formula Cleaning Products count text view
    private void updateoilCount() {
        tv7.setText(String.valueOf(oilCount));
    }

    private void updateformulaCount() {
        tv9.setText(String.valueOf(formulaCount));
    }

    private void showDialog(final String donationInfo) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Thanks for making a donation!")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        dialog.dismiss();
                        // Start NotificationActivity with donation information
                        Intent intent = new Intent(PostpregnancyActivity.this, NotificationActivity.class);
                        intent.putExtra("donationInfo", donationInfo);
                        startActivity(intent);
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
