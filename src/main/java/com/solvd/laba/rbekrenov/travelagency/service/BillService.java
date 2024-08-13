package com.solvd.laba.rbekrenov.travelagency.service;

import com.solvd.laba.rbekrenov.travelagency.pojo.Bill;
import com.solvd.laba.rbekrenov.travelagency.pojo.TravelAgency;

import java.util.UUID;

public class BillService {
    private final TravelAgency travelAgency;

    public BillService(TravelAgency travelAgency) {
        this.travelAgency = travelAgency;
    }

    public void payBill(Bill bill) {
        if(bill.isPaid()) return;
        if((travelAgency.getBudget() - bill.getAmount()) < 0){
            System.out.printf("Not enough money to pay bill %s\n", bill.getId());
            return;
        }
        System.out.printf("Paying bill (£%.2f)...\n", bill.getAmount());
        travelAgency.setBudget(travelAgency.getBudget() - bill.getAmount());
        bill.setPaid(true);
    }

    public void payBill(UUID billId) {
        Bill bill = null;
        for(Bill b : travelAgency.getBills()){
            if(b.getId().equals(billId)){
                bill = b;
            }
        }
        if(bill == null){
            System.out.printf("No bill with id %s", billId);
            return;
        }
        payBill(bill);
    }

    public void payAllBills() {
        for(Bill b : travelAgency.getBills()) {
            payBill(b);
        }
    }
}
