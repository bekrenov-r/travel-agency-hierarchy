package com.solvd.laba.rbekrenov.travelagency.finance.payment;

import com.solvd.laba.rbekrenov.travelagency.exception.NotEnoughMoneyException;

public interface PaymentCredentials {
    void pay(double amount) throws NotEnoughMoneyException;
    void increaseAmount(double amount);
    double getAmount();
}
