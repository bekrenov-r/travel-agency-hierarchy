package com.solvd.laba.travelagency.model.department;

import com.solvd.laba.travelagency.exception.NegativeAmountException;

public interface BudgetManagement {
    void addToBudget(double amount) throws NegativeAmountException;
    boolean budgetSuffices(double amount);
    double getAvailableBudget();
}