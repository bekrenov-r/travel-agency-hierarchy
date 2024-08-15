package com.solvd.laba.rbekrenov.travelagency.model;

import com.solvd.laba.rbekrenov.travelagency.model.location.Address;

import java.util.UUID;

public class Department {
    private String name;
    private Employee[] employees;
    private Address address;

    public Department(String name, Address address) {
        this.name = name;
        this.address = address;
        this.employees = new Employee[]{};
    }

    public Department(String name, Address address, Employee[] employees) {
        this.name = name;
        this.address = address;
        this.employees = employees;
    }

    public boolean hasEmployee(Employee employee) {
        for (Employee e : employees) {
            if (employee.equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int getTotalContractsCount(){
        int result = 0;
        for(Employee e : employees) {
            result += e.getContracts().length;
        }
        return result;
    }

    public void addEmployee(Employee employee){
        Employee[] employeesNew = new Employee[employees.length + 1];
        for(int i = 0; i < employees.length; i++){
            employeesNew[i] = employees[i];
        }
        employeesNew[employeesNew.length - 1] = employee;
        setEmployees(employeesNew);
    }

    public double calculateGrossIncome(){
        double result = 0.0;
        for(Employee e : employees){
            result += e.calculateAllContractsGrossIncome();
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
