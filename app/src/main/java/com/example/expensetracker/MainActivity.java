package com.example.expensetracker;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
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
    Button btnAdd, btnDelete;

    ExpenseCollection e;
    Category selectedCategory;

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

        scroll = findViewById(R.id.Scroll);
        container = findViewById(R.id.transactionContainer);
        btnAdd = findViewById(R.id.btnAdd);
        btnDelete = findViewById(R.id.btnDelete);

        // Initialize data
        e = new ExpenseCollection(3000);

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

        selectedCategory = c1;

        for (Category category : e.getCategories()) {
            for (Transaction t : category.getTransactions()) {
                addTransaction(t, category);
            }
        }

        btnAdd.setOnClickListener(v -> {
            Transaction newTransaction = new Transaction("Electricity Bill", 50);
            selectedCategory.addTransaction(newTransaction);
            addTransaction(newTransaction, selectedCategory);
        });

        btnDelete.setOnClickListener(v -> {
            if (!selectedCategory.getTransactions().isEmpty()) {
                selectedCategory.deleteTransaction(
                        selectedCategory.getTransactions().get(selectedCategory.getTransactions().size() - 1)
                );
                container.removeViewAt(container.getChildCount() - 1);
            }
        });
    }

    private void addTransaction(Transaction t, Category c) {
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        ll.setPadding(16, 16, 16, 16);

        LinearLayout.LayoutParams rowParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        rowParams.setMargins(0, 8, 0, 8);
        ll.setLayoutParams(rowParams);

        LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(
                0,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                1.0f
        );

        TextView expenseName = new TextView(this);
        expenseName.setText(t.name);
        expenseName.setLayoutParams(textParams);
        ll.addView(expenseName);

        TextView amount = new TextView(this);
        amount.setText(String.format("$%.2f", t.getAmount()));
        amount.setLayoutParams(textParams);
        ll.addView(amount);

        TextView categoryView = new TextView(this);
        categoryView.setText(c.getName());
        categoryView.setLayoutParams(textParams);
        ll.addView(categoryView);

        container.addView(ll);
    }
}
