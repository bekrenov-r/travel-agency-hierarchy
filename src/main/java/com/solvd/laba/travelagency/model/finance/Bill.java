package com.solvd.laba.travelagency.model.finance;

import com.solvd.laba.travelagency.model.finance.payment.PaymentCredentials;

import java.util.Objects;

public class Bill implements Payable {
    private String title;
    private double amount;
    private Currency currency;
    private boolean isPaid;
    private PaymentCredentials receiverCredentials;

    public Bill(String title, double amount, Currency currency, PaymentCredentials receiverCredentials) {
        this.title = title;
        this.amount = amount;
        this.currency = currency;
        this.receiverCredentials = receiverCredentials;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public boolean isPaid() {
        return isPaid;
    }

    @Override
    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    @Override
    public double getPrice() {
        return amount;
    }

    @Override
    public Currency getCurrency() {
        return currency;
    }

    public PaymentCredentials getReceiverCredentials() {
        return receiverCredentials;
    }

    public void setReceiverCredentials(PaymentCredentials receiverCredentials) {
        this.receiverCredentials = receiverCredentials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bill)) return false;
        Bill other = (Bill) o;

        return Objects.equals(title, other.title) && Objects.equals(amount, other.amount)
                && isPaid == other.isPaid;
    }

    @Override
    public int hashCode() {
        int hash = Objects.hashCode(title);
        hash = 31 * hash + Objects.hashCode(amount);
        hash = 31 * hash + (isPaid ? 1 : 0);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Bill{");
        sb.append("title='").append(title).append('\'');
        sb.append(", amount=").append(amount);
        sb.append(", isPaid=").append(isPaid);
        sb.append('}');
        return sb.toString();
    }
}
