package com.solvd.laba.travelagency.model;

import com.solvd.laba.travelagency.model.department.AccountingDepartment;
import com.solvd.laba.travelagency.model.department.HumanResourcesDepartment;
import com.solvd.laba.travelagency.model.department.SalesDepartment;
import com.solvd.laba.travelagency.model.finance.Bill;
import com.solvd.laba.travelagency.model.person.employee.Employee;
import com.solvd.laba.travelagency.util.CustomLinkedList;

import java.util.*;

public class TravelAgency {
    public static final double PERFORMANCE_BONUS = 250.0;
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
        for(SalesDepartment sd : salesDepartments){
            allEmployees.addAll(sd.getEmployees());
        }
        allEmployees.addAll(accountingDepartment.getEmployees());
        allEmployees.addAll(humanResourcesDepartment.getEmployees());
        return allEmployees;
    }

    public SalesDepartment getBestPerformingSalesDepartment() {
        if(salesDepartments.isEmpty()) return null;
        Iterator<SalesDepartment> iterator = salesDepartments.iterator();
        SalesDepartment result = iterator.next();
        while(iterator.hasNext()){
            SalesDepartment next = iterator.next();
            if(next.getTotalTripContractsCount() > result.getTotalTripContractsCount()){
                result = next;
            }
        }
        return result;
    }

    public double calculateGrossIncome(){
        double result = 0.0;
        for(SalesDepartment sd : salesDepartments){
            result += sd.calculateGrossIncome();
        }
        return result;
    }

    public double calculateOverallSalary() {
        double result = 0.0;
        for(Employee e : getAllEmployees()){
            result += e.calculateSalary();
        }
        return result;
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
