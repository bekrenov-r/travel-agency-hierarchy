package com.solvd.laba.rbekrenov.travelagency.model;

import java.util.Objects;

public class Bill {
    private String title;
    private double amount;
    private boolean isPaid;

    public Bill(String title, double amount, boolean isPaid) {
        this.title = title;
        this.amount = amount;
        this.isPaid = isPaid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
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
