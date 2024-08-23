package com.solvd.laba.rbekrenov.travelagency.service;

import com.solvd.laba.rbekrenov.travelagency.exception.NotEnoughMoneyException;
import com.solvd.laba.rbekrenov.travelagency.finance.Payable;
import com.solvd.laba.rbekrenov.travelagency.finance.payment.PaymentCredentials;

public class PaymentProcessor {
    public final void processPayment(Payable payable, PaymentCredentials paymentCredentials){
        double amount = payable.getPrice();
        try {
            paymentCredentials.pay(amount);
        } catch(NotEnoughMoneyException ex){
            System.out.println(ex.getMessage());
        }
        payable.setPaid(true);
    }
}
