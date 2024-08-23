package com.solvd.laba.rbekrenov.travelagency.department;

import com.solvd.laba.rbekrenov.travelagency.finance.Bill;

public interface BillManagement {
    void payBill(Bill bill);

    default void payAllBills(Bill[] bills) {
        for (Bill bill : bills) {
            payBill(bill);
        }
    }
}
