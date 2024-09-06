package com.solvd.laba.travelagency.model.department;

import com.solvd.laba.travelagency.model.finance.Bill;

public interface BillManagement {
    void payBill(Bill bill);

    default void payAllBills(Iterable<Bill> bills) {
        for (Bill bill : bills) {
            payBill(bill);
        }
    }
}
