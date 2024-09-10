package com.solvd.laba.travelagency.model.finance.payment;

import com.solvd.laba.travelagency.model.finance.Payable;

import java.time.LocalDateTime;

public class Transaction {
    private PaymentCredentials sender;
    private PaymentCredentials receiver;
    private Payable payable;
    private LocalDateTime timestamp;

    public Transaction(PaymentCredentials sender, PaymentCredentials receiver, Payable payable) {
        this.sender = sender;
        this.receiver = receiver;
        this.payable = payable;
    }

    public Transaction(PaymentCredentials sender, PaymentCredentials receiver, Payable payable, LocalDateTime timestamp) {
        this.sender = sender;
        this.receiver = receiver;
        this.timestamp = timestamp;
        this.payable = payable;
    }

    public PaymentCredentials getSender() {
        return sender;
    }

    public void setSender(PaymentCredentials sender) {
        this.sender = sender;
    }

    public PaymentCredentials getReceiver() {
        return receiver;
    }

    public void setReceiver(PaymentCredentials receiver) {
        this.receiver = receiver;
    }

    public Payable getPayable() {
        return payable;
    }

    public void setPayable(Payable payable) {
        this.payable = payable;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
