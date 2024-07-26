package com.example.aidatlas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

// DonationDetailsActivity.java
public class DonationDetailsActivity extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_details);

        listView = findViewById(R.id.lv);
        items = new ArrayList<>();

        // Retrieve incremented counts and item names for toys
        int top1Count = getIntent().getIntExtra("top1Count", 0);
        int top2Count = getIntent().getIntExtra("top2Count", 0);
        int top3Count = getIntent().getIntExtra("top3Count", 0);
        int top4Count = getIntent().getIntExtra("top4Count", 0);
        int top5Count = getIntent().getIntExtra("top5Count", 0);

        int car1Count = getIntent().getIntExtra("car1Count", 0);
        int car2Count = getIntent().getIntExtra("car2Count", 0);
        int car3Count = getIntent().getIntExtra("car3Count", 0);
        int car4Count = getIntent().getIntExtra("car4Count", 0);
        int car5Count = getIntent().getIntExtra("car5Count", 0);

        int bottom1Count = getIntent().getIntExtra("bottom1Count", 0);
        int bottom2Count = getIntent().getIntExtra("bottom2Count", 0);
        int bottom3Count = getIntent().getIntExtra("bottom3Count", 0);
        int bottom4Count = getIntent().getIntExtra("bottom4Count", 0);
        int bottom5Count = getIntent().getIntExtra("bottom5Count", 0);

        int shoes1Count = getIntent().getIntExtra("shoes1Count", 0);
        int shoes2Count = getIntent().getIntExtra("shoes2Count", 0);
        int shoes3Count = getIntent().getIntExtra("shoes3Count", 0);
        int shoes4Count = getIntent().getIntExtra("shoes4Count", 0);
        int shoes5Count = getIntent().getIntExtra("shoes5Count", 0);

// Retrieve incremented counts and item names for toys
        int doll1Count = getIntent().getIntExtra("doll1Count", 0);
        int doll2Count = getIntent().getIntExtra("doll2Count", 0);
        int doll3Count = getIntent().getIntExtra("doll3Count", 0);
        int doll4Count = getIntent().getIntExtra("doll4Count", 0);
        int doll5Count = getIntent().getIntExtra("doll5Count", 0);
// Retrieve incremented counts and item names for miscellaneous items
        int misc1Count = getIntent().getIntExtra("misc1Count", 0);
        int misc2Count = getIntent().getIntExtra("misc2Count", 0);
        int misc3Count = getIntent().getIntExtra("misc3Count", 0);
        int misc4Count = getIntent().getIntExtra("misc4Count", 0);
        int misc5Count = getIntent().getIntExtra("misc5Count", 0);


        // Populate the list with item names and counts for clothes
        if (top1Count > 0) {
            items.add("First Top: " + top1Count);
        } else if (top1Count < 0) {
            items.add("Invalid Amount");
        }

        if (top2Count > 0) {
            items.add("Second Top: " + top2Count);
        } else if (top2Count < 0) {
            items.add("Invalid Amount");
        }
        if (top3Count > 0) {
            items.add("Third Top: " + top3Count);
        } else if (top3Count < 0) {
            items.add("Invalid Amount");
        }

        if (top4Count > 0) {
            items.add("Fourth Top: " + top4Count);
        } else if (top4Count < 0) {
            items.add("Invalid Amount");
        }
        if (top5Count > 0) {
            items.add("Fifth Top: " + top5Count);
        } else if (top5Count < 0) {
            items.add("Invalid Amount");
        }
        if (car1Count > 0) {
            items.add("First Car: " + car1Count);
        } else if (car1Count < 0) {
            items.add("Invalid Amount");
        }

        if (car2Count > 0) {
            items.add("Second Car: " + car2Count);
        } else if (car2Count < 0) {
            items.add("Invalid Amount");
        }

        if (car3Count > 0) {
            items.add("Third Car: " + car3Count);
        } else if (car3Count < 0) {
            items.add("Invalid Amount");
        }

        if (car4Count > 0) {
            items.add("Fourth Car: " + car4Count);
        } else if (car4Count < 0) {
            items.add("Invalid Amount");
        }

        if (car5Count > 0) {
            items.add("Fifth Car: " + car5Count);
        } else if (car5Count < 0) {
            items.add("Invalid Amount");
        }

        // Populate the list with item names and counts for bottoms
        if (bottom1Count > 0) {
            items.add("First Bottom: " + bottom1Count);
        } else if (bottom1Count < 0) {
            items.add("Invalid Amount");
        }

        if (bottom2Count > 0) {
            items.add("Second Bottom: " + bottom2Count);
        } else if (bottom2Count < 0) {
            items.add("Invalid Amount");
        }

        if (bottom3Count > 0) {
            items.add("Third Bottom: " + bottom3Count);
        } else if (bottom3Count < 0) {
            items.add("Invalid Amount");
        }

        if (bottom4Count > 0) {
            items.add("Fourth Bottom: " + bottom4Count);
        } else if (bottom4Count < 0) {
            items.add("Invalid Amount");
        }

        if (bottom5Count > 0) {
            items.add("Fifth Bottom: " + bottom5Count);
        } else if (bottom5Count < 0) {
            items.add("Invalid Amount");
        }

        // Populate the list with item names and counts for shoes
        if (shoes1Count > 0) {
            items.add("First Shoes: " + shoes1Count);
        } else if (shoes1Count < 0) {
            items.add("Invalid Amount");
        }

        if (shoes2Count > 0) {
            items.add("Second Shoes: " + shoes2Count);
        } else if (shoes2Count < 0) {
            items.add("Invalid Amount");
        }
        if (shoes3Count > 0) {
            items.add("Third Shoes: " + shoes3Count);
        } else if (shoes3Count < 0) {
            items.add("Invalid Amount");
        }

        if (shoes4Count > 0) {
            items.add("Fourth Shoes: " + shoes4Count);
        } else if (shoes4Count < 0) {
            items.add("Invalid Amount");
        }

        if (shoes5Count > 0) {
            items.add("Fifth Shoes: " + shoes5Count);
        } else if (shoes5Count < 0) {
            items.add("Invalid Amount");
        }
        if (doll1Count > 0) {
            items.add("First Doll: " + doll1Count);
        } else if (doll1Count < 0) {
            items.add("Invalid Amount");
        }

        if (doll2Count > 0) {
            items.add("Second Doll: " + doll2Count);
        } else if (doll2Count < 0) {
            items.add("Invalid Amount");
        }
        if (doll3Count > 0) {
            items.add("Third Doll: " + doll3Count);
        } else if (doll3Count < 0) {
            items.add("Invalid Amount");
        }

        if (doll4Count > 0) {
            items.add("Fourth Doll: " + doll4Count);
        } else if (doll4Count < 0) {
            items.add("Invalid Amount");
        }
        if (doll5Count > 0) {
            items.add("Fifth Doll: " + doll5Count);
        } else if (doll5Count < 0) {
            items.add("Invalid Amount");
        }
        if (misc1Count > 0) {
            items.add("First Misc: " + misc1Count);
        } else if (misc1Count < 0) {
            items.add("Invalid Amount");
        }

        if (misc2Count > 0) {
            items.add("Second Misc: " + misc2Count);
        } else if (misc2Count < 0) {
            items.add("Invalid Amount");
        }
        if (misc3Count > 0) {
            items.add("Third Misc: " + misc3Count);
        } else if (misc3Count < 0) {
            items.add("Invalid Amount");
        }

        if (misc4Count > 0) {
            items.add("Fourth Misc: " + misc4Count);
        } else if (misc4Count < 0) {
            items.add("Invalid Amount");
        }
        if (misc5Count > 0) {
            items.add("Fifth Misc: " + misc5Count);
        } else if (misc5Count < 0) {
            items.add("Invalid Amount");
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        Button btnDonate = findViewById(R.id.b1);
        btnDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Display toast message "Successfully donated"
                Toast.makeText(getApplicationContext(), "Successfully donated", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
