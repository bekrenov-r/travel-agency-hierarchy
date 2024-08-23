package com.solvd.laba.rbekrenov.travelagency.department;

public interface BudgetManagement {
    void addToBudget(double amount);
    boolean budgetSuffices(double amount);
    double getAvailableBudget();
}