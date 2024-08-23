package com.solvd.laba.rbekrenov.travelagency.department;

import com.solvd.laba.rbekrenov.travelagency.location.Address;
import com.solvd.laba.rbekrenov.travelagency.person.employee.Employee;
import com.solvd.laba.rbekrenov.travelagency.person.employee.Salesman;

import java.util.Arrays;

public class SalesDepartment extends Department {
    public static final int TRIP_CONTRACTS_NEEDED_FOR_PERFORMANCE_BONUS = 3;

    private Salesman[] salesmen;

    public SalesDepartment(String name, Address address) {
        super(name, address);
        this.salesmen = new Salesman[]{};
    }

    @Override
    public void addEmployee(Employee employee) {
        if(!(employee instanceof Salesman)){
            throw new IllegalArgumentException("Employee is not salesman");
        }
        Salesman[] salesmenNew = new Salesman[salesmen.length + 1];
        for(int i = 0; i < salesmen.length; i++){
            salesmenNew[i] = salesmen[i];
        }
        salesmenNew[salesmenNew.length - 1] = (Salesman) employee;
        setSalesmen(salesmenNew);
    }

    @Override
    public Employee[] getEmployees() {
        Employee[] result = new Employee[salesmen.length];
        for(int i = 0; i < salesmen.length; i++){
            result[i] = salesmen[i];
        }
        return result;
    }

    public double calculateGrossIncome(){
        double result = 0.0;
        for(Employee e : getEmployees()){
            Salesman s = (Salesman) e;
            result += s.calculateAllContractsGrossIncome();
        }
        return result;
    }

    public int getTotalTripContractsCount(){
        int result = 0;
        for(Employee e : getEmployees()) {
            Salesman s = (Salesman) e;
            result += s.getTripContracts().length;
        }
        return result;
    }

    public Salesman[] getSalesmen() {
        return salesmen;
    }

    public void setSalesmen(Salesman[] salesmen) {
        this.salesmen = salesmen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SalesDepartment)) return false;
        SalesDepartment other = (SalesDepartment) o;

        return super.equals(o) && Arrays.equals(salesmen, other.salesmen);
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 29 * hash + Arrays.hashCode(salesmen);
        return hash;
    }
}
