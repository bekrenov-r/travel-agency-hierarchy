package com.solvd.laba.rbekrenov.travelagency.service;

import com.solvd.laba.rbekrenov.travelagency.model.Bill;
import com.solvd.laba.rbekrenov.travelagency.model.TravelAgency;

public class TravelAgencyService {
    private final TravelAgency travelAgency;
    private final EmployeeService employeeService;
    private final BillService billService;

    public TravelAgencyService(TravelAgency travelAgency) {
        this.travelAgency = travelAgency;
        this.employeeService = new EmployeeService();
        this.billService = new BillService();
    }

    public void grantPerformanceBonusToEmployees() {
        employeeService.grantPerformanceBonusToEmployees(travelAgency.getAllEmployees());
    }

    public void resetBonusForAllEmployees() {
        employeeService.resetBonusForAllEmployees(travelAgency.getAllEmployees());
    }

    public void payBill(Bill bill){
        if((travelAgency.getBudget() - bill.getAmount()) < 0){
            System.out.printf("Not enough money to pay bill '%s'\n", bill.getTitle());
            return;
        }
        billService.payBill(bill);
        travelAgency.subtractFromBudget(bill.getAmount());
    }

    public void payAllBills(){
        for(Bill b : travelAgency.getBills()){
            payBill(b);
        }
    }
}
