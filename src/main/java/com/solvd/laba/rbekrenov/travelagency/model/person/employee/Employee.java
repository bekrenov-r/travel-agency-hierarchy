package com.solvd.laba.rbekrenov.travelagency.model.person.employee;

import com.solvd.laba.rbekrenov.travelagency.model.finance.payment.PaymentCredentials;
import com.solvd.laba.rbekrenov.travelagency.model.person.ContactData;
import com.solvd.laba.rbekrenov.travelagency.model.person.Person;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Employee extends Person {
    private static final int YEARS_OF_SERVICE_NEEDED_FOR_SALARY_SUPPLEMENT = 5;
    private double monthSalary;
    private String occupation;
    private LocalDate employmentDate;
    private PaymentCredentials salaryCredentials;

    public Employee(String firstName, String lastName, LocalDate birthDate) {
        super(firstName, lastName, birthDate);
    }

    public Employee(String firstName, String lastName, LocalDate birthDate, ContactData contactData) {
        super(firstName, lastName, birthDate, contactData);
    }
    
    protected abstract double calculateBonus();

    public double calculateSalary() {
        return getMonthSalary() + calculateBonus() + calculateLengthOfServiceSupplement();
    }

    protected double calculateLengthOfServiceSupplement(){
        if(employmentDate == null) {
            throw new IllegalStateException("Employment date must not be null");
        }
        int yearsOfService = LocalDate.now().until(employmentDate).getYears();
        if(yearsOfService >= YEARS_OF_SERVICE_NEEDED_FOR_SALARY_SUPPLEMENT){
            return monthSalary * ((double) yearsOfService / 100);
        }
        return 0.0;
    }

    public double getMonthSalary() {
        return monthSalary;
    }

    public void setMonthSalary(double monthSalary) {
        this.monthSalary = monthSalary;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public PaymentCredentials getSalaryCredentials() {
        return salaryCredentials;
    }

    public void setSalaryCredentials(PaymentCredentials salaryCredentials) {
        this.salaryCredentials = salaryCredentials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee other = (Employee) o;

        return super.equals(o) && Objects.equals(monthSalary, other.monthSalary)
                && Objects.equals(occupation, other.occupation)
                && Objects.equals(employmentDate, other.employmentDate);
    }

    @Override
    public int hashCode() {
        int hash = Objects.hashCode(monthSalary);
        hash = 31 * hash + Objects.hashCode(occupation);
        hash = 31 * hash + Objects.hashCode(employmentDate);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Employee{");
        sb.append("fullName=").append(fullName());
        sb.append(", occupation='").append(occupation).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
