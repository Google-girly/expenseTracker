package com.example.expensetracker;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    ScrollView scroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        scroll = (ScrollView) findViewById(R.id.Scroll);
        LinearLayout ll = new LinearLayout(this);
        scroll.addView(ll);
        TextView expenseName = new TextView(this);
        expenseName.setText("Rent");
        ll.addView(expenseName);
        TextView amount = new TextView(this);
        amount.setText("$10");
        ll.addView(amount);
        TextView category = new TextView(this);
        category.setText("Rent");
        ll.addView(category);


//        LinearLayout ll1 = new LinearLayout(this);
//        scroll.addView(ll1);
//        TextView expenseName1 = new TextView(this);
//        expenseName1.setText("In-n-out");
//        ll1.addView(expenseName1);
//        TextView amount1 = new TextView(this);
//        amount1.setText("$15");
//        ll1.addView(amount1);
//        TextView category1 = new TextView(this);
//        category1.setText("Rent");
//        ll1.addView(category1);
    }
}