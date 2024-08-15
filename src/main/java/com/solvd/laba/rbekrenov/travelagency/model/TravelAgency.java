package com.solvd.laba.rbekrenov.travelagency.model;

public class TravelAgency {
    public static final double PERFORMANCE_BONUS = 250.0;
    public static final int CONTRACTS_NEEDED_FOR_PERFORMANCE_BONUS = 3;
    private String name;
    private Department[] departments;
    private Bill[] bills;
    private double budget;

    public TravelAgency(String name) {
        this.name = name;
        this.departments = new Department[]{};
        this.bills = new Bill[]{};
    }

    public TravelAgency(String name, Department[] departments, double budget) {
        this.name = name;
        this.departments = departments;
        this.bills = new Bill[]{};
        this.budget = budget;
    }

    public Employee[] getAllEmployees() {
        int totalEmployees = 0;
        for(Department d : departments){
            totalEmployees += d.getEmployees().length;
        }

        Employee[] allEmployees = new Employee[totalEmployees];
        int employeeIndex = 0;
        for(Department d : departments){
            for(Employee e : d.getEmployees()){
                allEmployees[employeeIndex] = e;
                employeeIndex++;
            }
        }
        return allEmployees;
    }

    public Department getBestPerformingDepartment() {
        Department result = departments[0];
        for(int i = 1; i < departments.length; i++){
            if(departments[i].getTotalContractsCount() > result.getTotalContractsCount()){
                result = departments[i];
            }
        }
        return result;
    }

    public double calculateGrossIncome(){
        double result = 0.0;
        for(Department d : departments){
            result += d.calculateGrossIncome();
        }
        return result;
    }

    public void subtractFromBudget(double amount) {
        budget -= amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department[] getDepartments() {
        return departments;
    }

    public void setDepartments(Department[] departments) {
        this.departments = departments;
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
}
