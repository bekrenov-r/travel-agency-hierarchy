package com.solvd.laba.travelagency.service;

import com.solvd.laba.travelagency.exception.AlreadyPaidException;
import com.solvd.laba.travelagency.exception.MoneyTransferReceiverException;
import com.solvd.laba.travelagency.exception.NotEnoughMoneyException;
import com.solvd.laba.travelagency.model.finance.Payable;
import com.solvd.laba.travelagency.model.finance.payment.PaymentCredentials;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PaymentProcessor {
    private static final Logger log = LogManager.getLogger(PaymentProcessor.class);

    private final Payable payable;
    private final PaymentCredentials sender;
    private final PaymentCredentials receiver;

    public PaymentProcessor(Payable payable, PaymentCredentials sender, PaymentCredentials receiver) {
        this.payable = payable;
        this.sender = sender;
        this.receiver = receiver;
    }

    public void processPayment() throws AlreadyPaidException {
        if(payable.isPaid()) throw new AlreadyPaidException();
        if(sender.equals(receiver)) throw new MoneyTransferReceiverException("Sender credentials cannot equal to receiver");
        double amount = payable.getPrice();
        try {
            sender.pay(amount, receiver);
            payable.setPaid(true);
        } catch(NotEnoughMoneyException ex){
            payable.setPaid(false);
            log.error(ex.getMessage());
        }
    }
}
