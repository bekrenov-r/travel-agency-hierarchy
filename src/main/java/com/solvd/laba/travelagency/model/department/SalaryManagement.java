package com.solvd.laba.travelagency.model.department;

import com.solvd.laba.travelagency.model.person.employee.Employee;

public interface SalaryManagement {
    void paySalary(Employee e);
    default void paySalaryToAllEmployees(Iterable<Employee> employees){
        employees.forEach(this::paySalary);
    }
}
