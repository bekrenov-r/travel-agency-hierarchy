package com.solvd.laba.rbekrenov.travelagency.model.finance.payment;

import com.solvd.laba.rbekrenov.travelagency.exception.NotEnoughMoneyException;

public interface PaymentCredentials {
    void pay(double amount, PaymentCredentials receiver) throws NotEnoughMoneyException;
    void receive(double amount);
    double getAvailableAmount();
}
