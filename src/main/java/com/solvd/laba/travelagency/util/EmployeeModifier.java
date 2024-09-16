package com.solvd.laba.travelagency.util;

import com.solvd.laba.travelagency.model.person.employee.Employee;

@FunctionalInterface
public interface EmployeeModifier<T extends Employee> {
    void modify(T employee);
}
