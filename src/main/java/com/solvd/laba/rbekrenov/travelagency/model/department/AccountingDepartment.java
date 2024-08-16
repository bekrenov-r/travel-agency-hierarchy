package com.solvd.laba.rbekrenov.travelagency.model.department;

import com.solvd.laba.rbekrenov.travelagency.model.location.Address;
import com.solvd.laba.rbekrenov.travelagency.model.person.Person;
import com.solvd.laba.rbekrenov.travelagency.model.person.employee.Accountant;
import com.solvd.laba.rbekrenov.travelagency.model.person.employee.Employee;

import java.util.Arrays;

public class AccountingDepartment extends Department {
    public static final int FINANCE_REPORTS_NEEDED_FOR_PERFORMANCE_BONUS = 2;
    private Accountant[] accountants;

    public AccountingDepartment(String name, Address address) {
        super(name, address);
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

    public Accountant[] getAccountants() {
        return accountants;
    }

    public void setAccountants(Accountant[] accountants) {
        this.accountants = accountants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountingDepartment other = (AccountingDepartment) o;
        return super.equals(o) && Arrays.equals(accountants, other.accountants);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(accountants);
        return result;
    }
}
