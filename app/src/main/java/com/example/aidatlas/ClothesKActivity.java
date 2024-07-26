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

public class ClothesKActivity extends AppCompatActivity {

    EditText etTop1, etTop2, etTop3, etTop4, etTop5;
    EditText etBottom1, etBottom2, etBottom3, etBottom4, etBottom5;
    EditText etShoes1, etShoes2, etShoes3, etShoes4, etShoes5;
    Button btnDonate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes_kactivity);

        // Initialize EditText fields for specifying the amount
        etTop1 = findViewById(R.id.etTop1);
        etTop2 = findViewById(R.id.etTop2);
        etTop3 = findViewById(R.id.etTop3);
        etTop4 = findViewById(R.id.etTop4);
        etTop5 = findViewById(R.id.etTop5);

        etBottom1 = findViewById(R.id.etBottom1);
        etBottom2 = findViewById(R.id.etBottom2);
        etBottom3 = findViewById(R.id.etBottom3);
        etBottom4 = findViewById(R.id.etBottom4);
        etBottom5 = findViewById(R.id.etBottom5);

        etShoes1 = findViewById(R.id.etShoes1);
        etShoes2 = findViewById(R.id.etShoes2);
        etShoes3 = findViewById(R.id.etShoes3);
        etShoes4 = findViewById(R.id.etShoes4);
        etShoes5 = findViewById(R.id.etShoes5);

        // Initialize donate button
        btnDonate = findViewById(R.id.btn_donate);

        // Set click listener for donate button
        btnDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the values entered by the user
                int top1Count = parseEditText(etTop1);
                int top2Count = parseEditText(etTop2);
                int top3Count = parseEditText(etTop3);
                int top4Count = parseEditText(etTop4);
                int top5Count= parseEditText(etTop5);
                int bottom1Count = parseEditText(etBottom1);
                int bottom2Count = parseEditText(etBottom2);
                int bottom3Count = parseEditText(etBottom3);
                int bottom4Count = parseEditText(etBottom4);
                int bottom5Count = parseEditText(etBottom5);

                int shoes1Count = parseEditText(etShoes1);
                int shoes2Count = parseEditText(etShoes2);
                int shoes3Count = parseEditText(etShoes3);
                int shoes4Count = parseEditText(etShoes4);
                int shoes5Count = parseEditText(etShoes5);

                // Display confirmation dialog
                showConfirmationDialog(top1Count, top2Count, top3Count, top4Count, top5Count,
                        bottom1Count, bottom2Count, bottom3Count, bottom4Count, bottom5Count,
                        shoes1Count, shoes2Count, shoes3Count, shoes4Count, shoes5Count);
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
    private void showConfirmationDialog(final int top1Count, final int top2Count, final int top3Count, final int top4Count, final int top5Count,
                                        final int bottom1Count, final int bottom2Count, final int bottom3Count, final int bottom4Count, final int bottom5Count,
                                        final int shoes1Count, final int shoes2Count, final int shoes3Count, final int shoes4Count, final int shoes5Count) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Thanks for donating clothes!")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        dialog.dismiss();
                        // Start DonationDetailsActivity with donation information
                        Intent intent = new Intent(ClothesKActivity.this, DonationDetailsActivity.class);
                        intent.putExtra("top1Count", top1Count);
                        intent.putExtra("top2Count", top2Count);
                        intent.putExtra("top3Count", top3Count);
                        intent.putExtra("top4Count", top4Count);
                        intent.putExtra("top5Count", top5Count);

                        intent.putExtra("bottom1Count", bottom1Count);
                        intent.putExtra("bottom2Count", bottom2Count);
                        intent.putExtra("bottom3Count", bottom3Count);
                        intent.putExtra("bottom4Count", bottom4Count);
                        intent.putExtra("bottom5Count", bottom5Count);

                        intent.putExtra("shoes1Count", shoes1Count);
                        intent.putExtra("shoes2Count", shoes2Count);
                        intent.putExtra("shoes3Count", shoes3Count);
                        intent.putExtra("shoes4Count", shoes4Count);
                        intent.putExtra("shoes5Count", shoes5Count);
                        startActivity(intent);
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }}

