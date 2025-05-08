package com.example.expensetracker;
import java.util.ArrayList;

public class Category {

    private String name;
    private String color;
    private final ArrayList<Transaction> transactions = new ArrayList<>();

    public Category(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ArrayList<Transaction> getCategories() {
        return transactions;
    }

    public void addTransaction (Transaction transaction){
        transactions.add(transaction);
    }

    public void deleteTransaction (Transaction transaction){
        transactions.remove(transaction);
    }

    public double totalAmount(){
        double total = 0.0;
        for(Transaction i: transactions){
            total += i.getAmount();
        }

        return total;
    }

    public int getCount(){
        return transactions.size();
    }
}
