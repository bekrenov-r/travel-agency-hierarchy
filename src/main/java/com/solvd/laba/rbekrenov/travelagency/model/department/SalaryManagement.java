package com.solvd.laba.rbekrenov.travelagency.model.department;

import com.solvd.laba.rbekrenov.travelagency.model.person.employee.Employee;

public interface SalaryManagement {
    void paySalary(Employee e);
    default void paySalaryToAllEmployees(Employee[] employees){
        for(Employee e : employees){
            paySalary(e);
        }
    }
}
