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
    LinearLayout container;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //container = findViewById(R.id.transactionContainer);

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        scroll = (ScrollView) findViewById(R.id.Scroll);
        container = findViewById(R.id.transactionContainer);
        ExpenseCollection e = new ExpenseCollection(3000);

        Category c1 = new Category("Rent", "Red");
        c1.addTransaction(new Transaction("1st half of rent", 700));
        c1.addTransaction(new Transaction("2nd half of rent", 700));
        c1.addTransaction(new Transaction("Light bill", 100));

        Category c2 = new Category("Groceries", "Green");
        c2.addTransaction(new Transaction("Fruits and veggies", 50));
        c2.addTransaction(new Transaction("Meat", 100));
        c2.addTransaction(new Transaction("Grains", 30));

        Category c3 = new Category("Transportation", "Blue");
        c3.addTransaction(new Transaction("Car payment", 200));
        c3.addTransaction(new Transaction("Gas", 150));
        c3.addTransaction(new Transaction("New air freshener", 10));

        e.addCategory(c1);
        e.addCategory(c2);
        e.addCategory(c3);

        for(Category category: e.getCategories()){
            for(Transaction t : category.getTransactions()){
                addTransaction(t,category);
            }
        }
        /*
        for (int i = 0; i < e.getCategories().size(); i++) {
            for (int k = 0; k < e.getCategories().get(i).getCount(); k++) {
                addTransaction(e.getCategories().get(i).getTransactions().get(k), e.getCategories().get(i));
            }
        }


        ---removed due to it duplicating entries------
        addTransaction(c1.getTransactions().get(0), c1);
        addTransaction(c1.getTransactions().get(0), c1);

    */
    }


    /*
    private void addTransaction(Transaction t, Category c) {
        LinearLayout ll = new LinearLayout(this);
        scroll.addView(ll);
        TextView expenseName = new TextView(this);
        expenseName.setText(t.name);
        ll.addView(expenseName);
        TextView amount = new TextView(this);
        amount.setText( String.valueOf(t.getAmount()));
        ll.addView(amount);
        TextView category = new TextView(this);
        category.setText(c.getName());
        ll.addView(category);
    }
}

     */
    private void addTransaction(Transaction t, Category c) {
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);

        TextView expenseName = new TextView(this);
        expenseName.setText(t.name);
        ll.addView(expenseName);

        TextView amount = new TextView(this);
        amount.setText(String.valueOf(t.getAmount()));
        ll.addView(amount);

        TextView category = new TextView(this);
        category.setText(c.getName());
        ll.addView(category);

        container.addView(ll);
    }
}
