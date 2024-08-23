package com.solvd.laba.rbekrenov.travelagency.department;

import com.solvd.laba.rbekrenov.travelagency.finance.Bill;
import com.solvd.laba.rbekrenov.travelagency.finance.payment.BankAccount;
import com.solvd.laba.rbekrenov.travelagency.location.Address;
import com.solvd.laba.rbekrenov.travelagency.person.employee.Accountant;
import com.solvd.laba.rbekrenov.travelagency.person.employee.Employee;
import com.solvd.laba.rbekrenov.travelagency.service.PaymentProcessor;

import java.util.Arrays;
import java.util.Objects;

public class AccountingDepartment extends Department implements BudgetManagement, BillManagement, SalaryManagement {
    public static final int FINANCE_REPORTS_NEEDED_FOR_PERFORMANCE_BONUS = 2;
    private BankAccount companyBankAccount;
    private Accountant[] accountants;

    public AccountingDepartment(String name, Address address) {
        super(name, address);
        this.accountants = new Accountant[]{};
    }

    public AccountingDepartment(String name, Address address, BankAccount companyBankAccount) {
        super(name, address);
        this.companyBankAccount = companyBankAccount;
        this.accountants = new Accountant[]{};
    }

    @Override
    public void addEmployee(Employee employee) {
        if(!(employee instanceof Accountant)){
            throw new IllegalArgumentException("Employee is not accountant");
        }
        Accountant[] accountantsNew = new Accountant[accountants.length + 1];
        for(int i = 0; i < accountants.length; i++){
            accountantsNew[i] = accountants[i];
        }
        accountantsNew[accountantsNew.length - 1] = (Accountant) employee;
        setAccountants(accountantsNew);
    }

    @Override
    public Employee[] getEmployees() {
        Employee[] result = new Employee[accountants.length];
        for(int i = 0; i < accountants.length; i++){
            result[i] = accountants[i];
        }
        return result;
    }

    @Override
    public void paySalary(Employee e) {
        double amount = e.calculateSalary();
        System.out.printf("Paying salary (£%.2f) for employee %s...\n", amount, e.fullName());
        companyBankAccount.pay(amount);
    }

    @Override
    public void payBill(Bill bill) {
        if (bill.isPaid()) return;
        new PaymentProcessor().processPayment(bill, companyBankAccount);
        System.out.printf("Paying bill (£%.2f)...\n", bill.getAmount());
    }

    @Override
    public void addToBudget(double amount) {
        companyBankAccount.increaseAmount(amount);
    }

    @Override
    public boolean budgetSuffices(double amount) {
        return companyBankAccount.getAmount() - amount > 0;
    }

    @Override
    public double getAvailableBudget() {
        return companyBankAccount.getAmount();
    }

    public Accountant[] getAccountants() {
        return accountants;
    }

    public void setAccountants(Accountant[] accountants) {
        this.accountants = accountants;
    }

    public BankAccount getCompanyBankAccount() {
        return companyBankAccount;
    }

    public void setCompanyBankAccount(BankAccount companyBankAccount) {
        this.companyBankAccount = companyBankAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountingDepartment other = (AccountingDepartment) o;
        return super.equals(o) && Arrays.equals(accountants, other.accountants)
                && Objects.equals(companyBankAccount, other.companyBankAccount);
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 31 * hash + Arrays.hashCode(accountants);
        hash = 31 * hash + Objects.hashCode(companyBankAccount);
        return hash;
    }
}
