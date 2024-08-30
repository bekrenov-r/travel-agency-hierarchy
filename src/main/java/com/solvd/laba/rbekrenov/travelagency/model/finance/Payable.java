package com.solvd.laba.rbekrenov.travelagency.model.finance;

public interface Payable {
    boolean isPaid();
    void setPaid(boolean paid);
    double getPrice();
}
