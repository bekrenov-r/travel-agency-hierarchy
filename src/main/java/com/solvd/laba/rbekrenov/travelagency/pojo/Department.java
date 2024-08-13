package com.solvd.laba.rbekrenov.travelagency.pojo;

import com.solvd.laba.rbekrenov.travelagency.pojo.location.Address;

import java.util.UUID;

public class Department {
    private String name;
    private Employee[] employees;
    private Address address;

    public Department(String name, Employee[] employees, Address address) {
        this.name = name;
        this.employees = employees;
        this.address = address;
    }

    public boolean hasEmployee(Employee employee) {
        for (Employee e : employees) {
            if (employee.getId().equals(e.getId())) {
                return true;
            }
        }
        return false;
    }

    public boolean hasEmployee(UUID employeeId) {
        for (Employee e : employees) {
            if (e.getId().equals(employeeId)) {
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
