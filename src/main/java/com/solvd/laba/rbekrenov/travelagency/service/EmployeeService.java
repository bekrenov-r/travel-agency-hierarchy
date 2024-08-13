package com.solvd.laba.rbekrenov.travelagency.service;

import com.solvd.laba.rbekrenov.travelagency.pojo.Employee;
import com.solvd.laba.rbekrenov.travelagency.pojo.TravelAgency;

public class EmployeeService {
    private final TravelAgency travelAgency;

    public EmployeeService(TravelAgency travelAgency) {
        this.travelAgency = travelAgency;
    }

    public void grantPerformanceBonusToEmployees(){
        Employee[] employees = travelAgency.getAllEmployees();
        for (Employee e : employees) {
            if (e.getContracts().length >= TravelAgency.CONTRACTS_NEEDED_FOR_PERFORMANCE_BONUS) {
                System.out.printf("Granting performance bonus (£%.2f) to employee %s...\n", TravelAgency.PERFORMANCE_BONUS, e.fullName());
                e.setBonus(TravelAgency.PERFORMANCE_BONUS);
            }
        }
    }

    public void resetBonusForAllEmployees(){
        Employee[] employees = travelAgency.getAllEmployees();
        for (Employee e : employees) {
            e.setBonus(0.0);
        }
    }
}
