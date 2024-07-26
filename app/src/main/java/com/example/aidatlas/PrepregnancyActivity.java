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

public class PrepregnancyActivity extends AppCompatActivity {
    TextView tv1,tv2,tv3,tv4,tv5;
    Button b1,b2,b3;
    int sup=0,med=0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prepregnancy);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        tv5 = (TextView) findViewById(R.id.tv5);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3=(Button) findViewById(R.id.b3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sup++;
                updatesup();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                med++;
                updatemed();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String donationInfo = "Donation Details:\n";
                if (sup > 0) {
                    donationInfo += "Supplements: " + sup + "\n";
                }
                if (med > 0) {
                    donationInfo += "Medicines " + med + "\n";
                }

                // Display donation information

                Toast.makeText(getApplicationContext(), donationInfo, Toast.LENGTH_LONG).show();

                // Show a dialog to thank for the donation
                showDialog(donationInfo);
            }
        });
    }
    private void updatesup() {
        tv4.setText(String.valueOf(sup));
    }

    // Update Tampons count text view
    private void updatemed() {
        tv5.setText(String.valueOf(med));
    }

    // Update Intimate Cleaning Products count text view

    private void showDialog(final String donationInfo) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Thanks for making a donation!")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        dialog.dismiss();
                        // Start NotificationActivity with donation information
                        Intent intent = new Intent(PrepregnancyActivity.this, NotificationActivity.class);
                        intent.putExtra("donationInfo", donationInfo);
                        startActivity(intent);
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}