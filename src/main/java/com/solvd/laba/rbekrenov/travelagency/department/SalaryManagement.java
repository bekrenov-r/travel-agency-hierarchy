package com.solvd.laba.rbekrenov.travelagency.department;

import com.solvd.laba.rbekrenov.travelagency.person.employee.Employee;

public interface SalaryManagement {
    void paySalary(Employee e);
    default void paySalaryToAllEmployees(Employee[] employees){
        for(Employee e : employees){
            paySalary(e);
        }
    }
}
