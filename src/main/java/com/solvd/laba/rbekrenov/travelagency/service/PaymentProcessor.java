package com.solvd.laba.rbekrenov.travelagency.service;

import com.solvd.laba.rbekrenov.travelagency.exception.AlreadyPaidException;
import com.solvd.laba.rbekrenov.travelagency.exception.MoneyTransferReceiverException;
import com.solvd.laba.rbekrenov.travelagency.exception.NotEnoughMoneyException;
import com.solvd.laba.rbekrenov.travelagency.model.finance.Payable;
import com.solvd.laba.rbekrenov.travelagency.model.finance.payment.PaymentCredentials;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PaymentProcessor {
    private static final Logger log = LogManager.getLogger(PaymentProcessor.class);

    public static void processPayment(Payable payable, PaymentCredentials sender, PaymentCredentials receiver) throws AlreadyPaidException {
        if(payable.isPaid()) throw new AlreadyPaidException();
        if(sender.equals(receiver)) throw new MoneyTransferReceiverException("Sender credentials cannot equal to receiver");
        double amount = payable.getPrice();
        try {
            sender.pay(amount, receiver);
        } catch(NotEnoughMoneyException ex){
            log.error(ex.getMessage());
        }
        payable.setPaid(true);
    }
}
