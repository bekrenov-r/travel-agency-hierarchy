package com.solvd.laba.rbekrenov.travelagency.pojo;

public class TravelAgency {
    public static final double PERFORMANCE_BONUS = 250.0;
    public static final int CONTRACTS_NEEDED_FOR_PERFORMANCE_BONUS = 3;
    private String name;
    private Department[] departments;
    private Bill[] bills;
    private double budget;

    public TravelAgency(String name, Department[] departments, Bill[] bills, double budget) {
        this.name = name;
        this.departments = departments;
        this.bills = bills;
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
        Employee[] employees = getAllEmployees();
        int contractsLength = 0;
        for(Department d : departments) {
            contractsLength += d.getTotalContractsCount();
        }

        Contract[] allContracts = new Contract[contractsLength];
        int contractIndex = 0;
        for(Employee e : employees) {
            for(Contract c : e.getContracts()){
                allContracts[contractIndex] = c;
                contractIndex++;
            }
        }

        double result = 0.0;
        for(Contract c : allContracts){
            result += c.getTrip().getTotalCost();
        }
        return result;
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
