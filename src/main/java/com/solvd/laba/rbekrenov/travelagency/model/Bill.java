package com.solvd.laba.rbekrenov.travelagency.model;

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
}
