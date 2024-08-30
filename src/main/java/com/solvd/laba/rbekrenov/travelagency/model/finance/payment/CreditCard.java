package com.solvd.laba.rbekrenov.travelagency.model.finance.payment;

import com.solvd.laba.rbekrenov.travelagency.exception.NotEnoughMoneyException;

import java.util.Objects;

public class CreditCard implements PaymentCredentials {
    private String number;
    private String expirationDate;
    private String cvv;
    private double amount;

    public CreditCard(String number, String expirationDate, String cvv) {
        this.number = number;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }

    public CreditCard(String number, String expirationDate, String cvv, double amount) {
        this.number = number;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.amount = amount;
    }

    @Override
    public void pay(double amount, PaymentCredentials receiver) throws NotEnoughMoneyException {
        if(this.amount < amount){
            throw new NotEnoughMoneyException();
        }
        this.amount -= amount;
        receiver.receive(amount);
    }

    @Override
    public void receive(double amount) {
        if(amount <= 0)
            throw new IllegalArgumentException("Only positive amount allowed for this operation");
        this.amount += amount;
    }

    @Override
    public double getAvailableAmount() {
        return amount;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreditCard)) return false;
        CreditCard other = (CreditCard) o;

        return Objects.equals(cvv, other.cvv) && (Objects.equals(amount, other.amount))
                && (!Objects.equals(number, other.number))
                && (!Objects.equals(expirationDate, other.expirationDate));
    }

    @Override
    public int hashCode() {
        int hash = Objects.hashCode(number);
        hash = 31 * hash + Objects.hashCode(expirationDate);
        hash = 31 * hash + Objects.hashCode(cvv);
        hash = 31 * hash + Objects.hashCode(amount);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CreditCard{");
        sb.append("number='").append(number).append('\'');
        sb.append(", expirationDate='").append(expirationDate).append('\'');
        sb.append(", cvv='").append(cvv).append('\'');
        sb.append(", amount=").append(amount);
        sb.append('}');
        return sb.toString();
    }
}
