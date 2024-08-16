package com.solvd.laba.rbekrenov.travelagency.service;

import com.solvd.laba.rbekrenov.travelagency.model.Bill;
import com.solvd.laba.rbekrenov.travelagency.model.TravelAgency;
import com.solvd.laba.rbekrenov.travelagency.model.person.Client;
import com.solvd.laba.rbekrenov.travelagency.model.person.employee.Employee;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class TravelAgencyService {
    private final TravelAgency travelAgency;
    private final BillService billService;

    public TravelAgencyService(TravelAgency travelAgency) {
        this.travelAgency = travelAgency;
        this.billService = new BillService();
    }

    public void paySalaryToAllEmployees(Employee[] employees){
        for(Employee e : employees){
            paySalary(e);
        }
    }

    private void paySalary(Employee e){
        double salary = e.calculateSalary();
        System.out.printf("Paying salary (£%.2f) for employee %s...\n", salary, e.fullName());
        travelAgency.subtractFromBudget(salary);
    }

    public void payBill(Bill bill){
        billService.payBill(bill);
        travelAgency.subtractFromBudget(bill.getAmount());
    }

    public void payAllBills(){
        for(Bill b : travelAgency.getBills()){
            payBill(b);
        }
    }

    public int calculateAverageEmployeeAge(Employee[] employees) {
        int sum = 0;
        for(Employee e : employees){
            sum += e.getAgeYears();
        }
        return sum / employees.length;
    }

    public int calculateAverageClientAge(Client[] clients) {
        int sum = 0;
        for(Client c : clients){
            sum += c.getAgeYears();
        }
        return sum / clients.length;
    }
}
