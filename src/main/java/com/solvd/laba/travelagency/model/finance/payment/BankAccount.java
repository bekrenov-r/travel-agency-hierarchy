package com.solvd.laba.travelagency.model.finance.payment;

import com.solvd.laba.travelagency.exception.NegativeAmountException;
import com.solvd.laba.travelagency.exception.NotEnoughMoneyException;

import java.util.Objects;

public class BankAccount implements PaymentCredentials {
    private static final String CREDENTIAL_TYPE = "BANK_ACCOUNT";
    private String number;
    private double amount;

    public BankAccount(String number, double amount) {
        this.number = number;
        this.amount = amount;
    }

    @Override
    public void pay(double amount, PaymentCredentials receiver) throws NotEnoughMoneyException {
        if(amount <= 0) {
            throw new NegativeAmountException(amount);
        }
        if(this.amount < amount){
            throw new NotEnoughMoneyException();
        }
        this.amount -= amount;
        receiver.receive(amount);
    }

    @Override
    public void receive(double amount) {
        if(amount <= 0){
            throw new IllegalArgumentException("Only positive amount allowed for this operation");
        }
        this.amount += amount;
    }

    @Override
    public double getAvailableAmount() {
        return amount;
    }

    @Override
    public String getCredentialType() {
        return CREDENTIAL_TYPE;
    }

    @Override
    public String getCredentialId() {
        return number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount)) return false;
        BankAccount other = (BankAccount) o;

        return Objects.equals(number, other.number) && Objects.equals(amount, other.amount);
    }

    @Override
    public int hashCode() {
        int hash = Objects.hashCode(number);
        hash = 31 * hash + Objects.hashCode(amount);
        return hash;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BankAccount{");
        sb.append("number='").append(number).append('\'');
        sb.append(", amount=").append(amount);
        sb.append('}');
        return sb.toString();
    }
}
