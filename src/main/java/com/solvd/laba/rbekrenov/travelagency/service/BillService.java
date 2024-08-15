package com.solvd.laba.rbekrenov.travelagency.service;

import com.solvd.laba.rbekrenov.travelagency.model.Bill;

public class BillService {

    public void payBill(Bill bill) {
        if(bill.isPaid()) return;
        System.out.printf("Paying bill (£%.2f)...\n", bill.getAmount());
        bill.setPaid(true);
    }
}
