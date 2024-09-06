package com.solvd.laba.travelagency.model.finance;

public interface Payable {
    boolean isPaid();
    void setPaid(boolean paid);
    double getPrice();
}
