package com.solvd.laba.travelagency.model.department;

import com.solvd.laba.travelagency.model.location.Address;
import com.solvd.laba.travelagency.model.person.employee.Employee;
import com.solvd.laba.travelagency.model.person.employee.Salesman;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class SalesDepartment extends Department {
    public static final int TRIP_CONTRACTS_NEEDED_FOR_PERFORMANCE_BONUS = 3;

    private List<Salesman> salesmen;

    public SalesDepartment(String name, Address address) {
        super(name, address);
        this.salesmen = new ArrayList<>();
    }

    @Override
    public void addEmployee(Employee employee) {
        if(!(employee instanceof Salesman)){
            throw new IllegalArgumentException("Employee is not salesman");
        }
        salesmen.add((Salesman) employee);
    }

    @Override
    public Collection<Employee> getEmployees() {
        return new ArrayList<>(salesmen);
    }

    public double calculateGrossIncome(){
        return getSalesmen().stream()
                .map(Salesman::calculateAllContractsGrossIncome)
                .reduce(0.0, Double::sum);
    }

    public int getTotalTripContractsCount(){
        return getSalesmen().stream()
                .map(s -> s.getTripContracts().size())
                .reduce(0, Integer::sum);
    }

    public List<Salesman> getSalesmen() {
        return salesmen;
    }

    public void setSalesmen(List<Salesman> salesmen) {
        this.salesmen = salesmen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SalesDepartment)) return false;
        SalesDepartment other = (SalesDepartment) o;

        return super.equals(o) && Objects.equals(salesmen, other.salesmen);
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 29 * hash + Objects.hashCode(salesmen);
        return hash;
    }
}
