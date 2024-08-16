package com.solvd.laba.rbekrenov.travelagency.model;

import com.solvd.laba.rbekrenov.travelagency.model.department.AccountingDepartment;
import com.solvd.laba.rbekrenov.travelagency.model.department.Department;
import com.solvd.laba.rbekrenov.travelagency.model.department.HumanResourcesDepartment;
import com.solvd.laba.rbekrenov.travelagency.model.department.SalesDepartment;
import com.solvd.laba.rbekrenov.travelagency.model.person.employee.Accountant;
import com.solvd.laba.rbekrenov.travelagency.model.person.employee.Employee;
import com.solvd.laba.rbekrenov.travelagency.model.person.employee.Salesman;

import java.util.Arrays;
import java.util.Objects;

public class TravelAgency {
    public static final double PERFORMANCE_BONUS = 250.0;
    private String name;
    private SalesDepartment[] salesDepartments;
    private AccountingDepartment accountingDepartment;
    private HumanResourcesDepartment humanResourcesDepartment;
    private Bill[] bills;
    private double budget;

    public TravelAgency(String name) {
        this.name = name;
        this.salesDepartments = new SalesDepartment[]{};
        this.bills = new Bill[]{};
    }

    public TravelAgency(String name, SalesDepartment[] departments, double budget) {
        this.name = name;
        this.salesDepartments = departments;
        this.bills = new Bill[]{};
        this.budget = budget;
    }

    public Employee[] getAllEmployees() {
        int totalEmployees = 0;
        for(SalesDepartment sd : salesDepartments){
            totalEmployees += sd.getEmployees().length;
        }
        totalEmployees += accountingDepartment.getEmployees().length;
        totalEmployees += humanResourcesDepartment.getEmployees().length;

        Employee[] allEmployees = new Employee[totalEmployees];
        int index = 0;
        for(SalesDepartment sd : salesDepartments){
            for(Employee e : sd.getEmployees()){
                allEmployees[index] = e;
                index++;
            }
        }
        for(Employee e : accountingDepartment.getEmployees()){
            allEmployees[index] = e;
            index++;
        }
        for(Employee e : humanResourcesDepartment.getEmployees()){
            allEmployees[index] = e;
            index++;
        }
        return allEmployees;
    }

    public SalesDepartment getBestPerformingSalesDepartment() {
        SalesDepartment result = salesDepartments[0];
        for(int i = 1; i < salesDepartments.length; i++){
            if(salesDepartments[i].getTotalTripContractsCount() > result.getTotalTripContractsCount()){
                result = salesDepartments[i];
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

    public void subtractFromBudget(double amount) {
        if(budget - amount < 0){
            System.out.printf("Not enough money for this operation(amount to subtract: £%.2f; available budget: £%.2f)\n", amount, budget);
            return;
        }
        budget -= amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SalesDepartment[] getSalesDepartments() {
        return salesDepartments;
    }

    public void setSalesDepartments(SalesDepartment[] salesDepartments) {
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

    public Bill[] getBills() {
        return bills;
    }

    public void setBills(Bill[] bills) {
        this.bills = bills;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TravelAgency)) return false;
        TravelAgency other = (TravelAgency) o;

        return Objects.equals(other.budget, budget) && Objects.equals(name, other.name)
                && Arrays.equals(salesDepartments, other.salesDepartments)
                && Objects.equals(accountingDepartment, other.accountingDepartment)
                && Objects.equals(humanResourcesDepartment, other.humanResourcesDepartment)
                && Arrays.equals(bills, other.bills);
    }

    @Override
    public int hashCode() {
        int hash = Objects.hashCode(name);
        hash = 31 * hash + Arrays.hashCode(salesDepartments);
        hash = 31 * hash + Objects.hashCode(accountingDepartment);
        hash = 31 * hash + Objects.hashCode(humanResourcesDepartment);
        hash = 31 * hash + Arrays.hashCode(bills);
        hash = 31 * hash + Objects.hashCode(budget);
        return hash;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TravelAgency{");
        sb.append("name='").append(name).append('\'');
        sb.append(", budget=").append(budget);
        sb.append('}');
        return sb.toString();
    }
}
