package com.example.aidatlas;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class ToysActivity extends AppCompatActivity {

    EditText etCars1, etCars2, etCars3, etCars4, etCars5;
    EditText etMisc1, etMisc2, etMisc3, etMisc4, etMisc5;
    EditText etDolls1, etDolls2, etDolls3, etDolls4, etDolls5;
    Button btnDonate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toys);

        // Initialize EditText fields for specifying the amount
        etCars1 = findViewById(R.id.etCars1);
        etCars2 = findViewById(R.id.etCars2);
        etCars3 = findViewById(R.id.etCars3);
        etCars4 = findViewById(R.id.etCars4);
        etCars5 = findViewById(R.id.etCars5);

        etMisc1 = findViewById(R.id.etMisc1);
        etMisc2 = findViewById(R.id.etMisc2);
        etMisc3 = findViewById(R.id.etMisc3);
        etMisc4 = findViewById(R.id.etMisc4);
        etMisc5 = findViewById(R.id.etMisc5);

        etDolls1 = findViewById(R.id.etDolls1);
        etDolls2 = findViewById(R.id.etDolls2);
        etDolls3 = findViewById(R.id.etDolls3);
        etDolls4 = findViewById(R.id.etDolls4);
        etDolls5 = findViewById(R.id.etDolls5);

        // Initialize donate button
        btnDonate = findViewById(R.id.btn_donate);

        // Set click listener for donate button
        btnDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the values entered by the user
                int Cars1Count = parseEditText(etCars1);
                int Cars2Count = parseEditText(etCars2);
                int Cars3Count = parseEditText(etCars3);
                int Cars4Count = parseEditText(etCars4);
                int Cars5Count= parseEditText(etCars5);
                int Misc1Count = parseEditText(etMisc1);
                int Misc2Count = parseEditText(etMisc2);
                int Misc3Count = parseEditText(etMisc3);
                int Misc4Count = parseEditText(etMisc4);
                int Misc5Count = parseEditText(etMisc5);

                int Dolls1Count = parseEditText(etDolls1);
                int Dolls2Count = parseEditText(etDolls2);
                int Dolls3Count = parseEditText(etDolls3);
                int Dolls4Count = parseEditText(etDolls4);
                int Dolls5Count = parseEditText(etDolls5);

                // Display confirmation dialog
                showConfirmationDialog(Cars1Count, Cars2Count, Cars3Count, Cars4Count, Cars5Count,
                        Misc1Count, Misc2Count, Misc3Count, Misc4Count, Misc5Count,
                        Dolls1Count, Dolls2Count, Dolls3Count, Dolls4Count, Dolls5Count);
            }
        });
    }

    // Method to parse the value of EditText and return 0 if empty
    private int parseEditText(EditText editText) {
        String value = editText.getText().toString().trim();
        if (value.isEmpty()) {
            return 0;
        } else {
            return Integer.parseInt(value);
        }
    }

    // Method to show confirmation dialog
    private void showConfirmationDialog(final int Cars1Count, final int Cars2Count, final int Cars3Count, final int Cars4Count, final int Cars5Count,
                                        final int Misc1Count, final int Misc2Count, final int Misc3Count, final int Misc4Count, final int Misc5Count,
                                        final int Dolls1Count, final int Dolls2Count, final int Dolls3Count, final int Dolls4Count, final int Dolls5Count) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Thanks for donating clothes!")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        dialog.dismiss();
                        // Start DonationDetailsActivity with donation information
                        Intent intent = new Intent(ToysActivity.this, DonationDetailsActivity.class);
                        // Corrected naming convention for extras
                        intent.putExtra("car1Count", Cars1Count);
                        intent.putExtra("car2Count", Cars2Count);
                        intent.putExtra("car3Count", Cars3Count);
                        intent.putExtra("car4Count", Cars4Count);
                        intent.putExtra("car5Count", Cars5Count);

                        intent.putExtra("misc1Count", Misc1Count);
                        intent.putExtra("misc2Count", Misc2Count);
                        intent.putExtra("misc3Count", Misc3Count);
                        intent.putExtra("misc4Count", Misc4Count);
                        intent.putExtra("misc5Count", Misc5Count);

                        intent.putExtra("doll1Count", Dolls1Count);
                        intent.putExtra("doll2Count", Dolls2Count);
                        intent.putExtra("doll3Count", Dolls3Count);
                        intent.putExtra("doll4Count", Dolls4Count);
                        intent.putExtra("doll5Count", Dolls5Count);

                        startActivity(intent);
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }}

