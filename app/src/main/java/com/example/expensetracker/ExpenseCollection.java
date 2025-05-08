package com.example.expensetracker;

import java.util.ArrayList;

public class ExpenseCollection {
    private final ArrayList<Category> categories = new ArrayList<>();
    private double monthlyIncome;

    public ExpenseCollection(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public void deleteCategory (Category category){
        categories.remove(category);
    }

    public void addCategory (Category category){
        categories.add(category);
    }

    public double getPercentage (Category category){
        double amountSpent =  category.totalAmount();
        return 100/monthlyIncome * amountSpent;
    }


}
