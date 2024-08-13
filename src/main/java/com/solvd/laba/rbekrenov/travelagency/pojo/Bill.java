package com.solvd.laba.rbekrenov.travelagency.pojo;

import java.util.UUID;

public class Bill {
    private UUID id;
    private String title;
    private double amount;
    private boolean isPaid;

    public Bill(String title, double amount, boolean isPaid) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.amount = amount;
        this.isPaid = isPaid;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
