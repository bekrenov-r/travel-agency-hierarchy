package com.solvd.laba.travelagency.model;

import com.solvd.laba.travelagency.model.department.AccountingDepartment;
import com.solvd.laba.travelagency.model.department.HumanResourcesDepartment;
import com.solvd.laba.travelagency.model.department.SalesDepartment;
import com.solvd.laba.travelagency.model.finance.Bill;
import com.solvd.laba.travelagency.model.finance.Currency;
import com.solvd.laba.travelagency.model.person.employee.Employee;
import com.solvd.laba.travelagency.util.CustomLinkedList;
import com.solvd.laba.travelagency.util.EmployeeModifier;

import java.util.*;

public class TravelAgency {
    public static final double PERFORMANCE_BONUS = 250.0;
    public static final Currency PRIMARY_CURRENCY = Currency.GBP;
    private String name;
    private Set<SalesDepartment> salesDepartments;
    private AccountingDepartment accountingDepartment;
    private HumanResourcesDepartment humanResourcesDepartment;
    private List<Bill> bills;

    public TravelAgency(String name) {
        this.name = name;
        this.salesDepartments = new HashSet<>();
        this.bills = new CustomLinkedList<>();
    }

    public List<Employee> getAllEmployees() {
        List<Employee> allEmployees = new LinkedList<>();
        salesDepartments.forEach(sd -> allEmployees.addAll(sd.getEmployees()));
        allEmployees.addAll(accountingDepartment.getEmployees());
        allEmployees.addAll(humanResourcesDepartment.getEmployees());
        return allEmployees;
    }

    public Optional<SalesDepartment> getBestPerformingSalesDepartment() {
        return salesDepartments.stream()
                .max(Comparator.comparingInt(SalesDepartment::getTotalTripContractsCount));
    }

    public void modifyAllEmployees(EmployeeModifier<Employee> modifier) {
        getAllEmployees().forEach(modifier::modify);
    }

    public double calculateGrossIncome(){
        return salesDepartments.stream()
                .map(SalesDepartment::calculateGrossIncome)
                .reduce(0.0, Double::sum);
    }

    public double calculateOverallSalary() {
        return getAllEmployees().stream()
                .map(Employee::calculateSalary)
                .reduce(0.0, Double::sum);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<SalesDepartment> getSalesDepartments() {
        return salesDepartments;
    }

    public void setSalesDepartments(Set<SalesDepartment> salesDepartments) {
        this.salesDepartments = salesDepartments;
    }

    public AccountingDepartment getAccountingDepartment() {
        return accountingDepartment;
    }

    public void setAccountingDepartment(AccountingDepartment accountingDepartment) {
        this.accountingDepartment = accountingDepartment;
    }

    public HumanResourcesDepartment getHumanResourcesDepartment() {
        return humanResourcesDepartment;
    }

    public void setHumanResourcesDepartment(HumanResourcesDepartment humanResourcesDepartment) {
        this.humanResourcesDepartment = humanResourcesDepartment;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TravelAgency)) return false;
        TravelAgency other = (TravelAgency) o;

        return Objects.equals(name, other.name) && Objects.equals(salesDepartments, other.salesDepartments)
                && Objects.equals(accountingDepartment, other.accountingDepartment)
                && Objects.equals(humanResourcesDepartment, other.humanResourcesDepartment)
                && Objects.equals(bills, other.bills);
    }

    @Override
    public int hashCode() {
        int hash = Objects.hashCode(name);
        hash = 31 * hash + Objects.hashCode(salesDepartments);
        hash = 31 * hash + Objects.hashCode(accountingDepartment);
        hash = 31 * hash + Objects.hashCode(humanResourcesDepartment);
        hash = 31 * hash + Objects.hashCode(bills);
        return hash;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TravelAgency{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
