package com.solvd.laba.rbekrenov.travelagency.model.department;

import com.solvd.laba.rbekrenov.travelagency.exception.IncorrectAmountException;

public interface BudgetManagement {
    void addToBudget(double amount) throws IncorrectAmountException;
    boolean budgetSuffices(double amount);
    double getAvailableBudget();
}