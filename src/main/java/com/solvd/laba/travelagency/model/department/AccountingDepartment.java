package com.solvd.laba.travelagency.model.department;

import com.solvd.laba.travelagency.exception.AlreadyPaidException;
import com.solvd.laba.travelagency.exception.NegativeAmountException;
import com.solvd.laba.travelagency.model.finance.Bill;
import com.solvd.laba.travelagency.model.finance.payment.BankAccount;
import com.solvd.laba.travelagency.model.finance.payment.Transaction;
import com.solvd.laba.travelagency.model.location.Address;
import com.solvd.laba.travelagency.model.person.employee.Accountant;
import com.solvd.laba.travelagency.model.person.employee.Employee;
import com.solvd.laba.travelagency.service.PaymentProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class AccountingDepartment extends Department implements BudgetManagement, BillManagement, SalaryManagement {
    private static final Logger log = LogManager.getLogger(AccountingDepartment.class);

    public static final int FINANCE_REPORTS_NEEDED_FOR_PERFORMANCE_BONUS = 2;

    private BankAccount companyBankAccount;
    private List<Accountant> accountants;

    public AccountingDepartment(String name, Address address) {
        super(name, address);
        this.accountants = new ArrayList<>();
    }

    public AccountingDepartment(String name, Address address, BankAccount companyBankAccount) {
        super(name, address);
        this.companyBankAccount = companyBankAccount;
        this.accountants = new ArrayList<>();
    }

    @Override
    public void addEmployee(Employee employee) {
        if(!(employee instanceof Accountant)){
            throw new IllegalArgumentException("Employee is not accountant");
        }
        accountants.add((Accountant) employee);
    }

    @Override
    public Collection<Employee> getEmployees() {
        return new ArrayList<>(accountants);
    }

    @Override
    public void paySalary(Employee e) {
        double amount = e.calculateSalary();
        Bill salary = new Bill("Salary", amount, e.getSalaryCredentials());
        Transaction transaction = new Transaction(companyBankAccount, e.getSalaryCredentials(), salary);
        try {
            log.info("Paying salary (£{}) for employee {}...", amount, e.fullName());
            PaymentProcessor.processTransaction(transaction);
        } catch(AlreadyPaidException ex){
            log.error(ex.getMessage(), ex);
        }
    }

    @Override
    public void payBill(Bill bill) {
        Transaction transaction = new Transaction(companyBankAccount, bill.getReceiverCredentials(), bill);
        try {
            log.info("Paying bill (£{})...", bill.getPrice());
            PaymentProcessor.processTransaction(transaction);
        } catch (AlreadyPaidException ex){
            log.error(ex.getMessage(), ex);
        }
    }

    @Override
    public void addToBudget(double amount) {
        if(amount <= 0) {
            throw new NegativeAmountException(amount);
        }
        companyBankAccount.receive(amount);
    }

    @Override
    public boolean budgetSuffices(double amount) {
        return companyBankAccount.getAvailableAmount() - amount > 0;
    }

    @Override
    public double getAvailableBudget() {
        return companyBankAccount.getAvailableAmount();
    }

    public List<Accountant> getAccountants() {
        return accountants;
    }

    public void setAccountants(List<Accountant> accountants) {
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
        return super.equals(o) && Objects.equals(accountants, other.accountants)
                && Objects.equals(companyBankAccount, other.companyBankAccount);
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 31 * hash + Objects.hashCode(accountants);
        hash = 31 * hash + Objects.hashCode(companyBankAccount);
        return hash;
    }
}
