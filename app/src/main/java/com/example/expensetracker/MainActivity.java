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
        ExpenseCollection e = new ExpenseCollection(3000);
        e.addCategory(new Category("Rent", "Red"));
        e.addCategory(new Category("Groceries", "Green"));
        e.addCategory(new Category("Transportation", "Blue"));
        addTransaction(transaction);


    }

    private void addTransaction(Transaction t) {
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
    }
}