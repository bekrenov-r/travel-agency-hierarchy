package com.solvd.laba.travelagency.model.person.employee;

import com.solvd.laba.travelagency.model.TravelAgency;
import com.solvd.laba.travelagency.model.department.AccountingDepartment;
import com.solvd.laba.travelagency.model.finance.FinancialReport;
import com.solvd.laba.travelagency.model.person.ContactData;

import java.time.LocalDate;
import java.util.*;

public class Accountant extends Employee {
    private List<FinancialReport> reports;

    public Accountant(String firstName, String lastName, LocalDate birthDate) {
        super(firstName, lastName, birthDate);
        this.reports = new ArrayList<>();
    }

    public Accountant(String firstName, String lastName, LocalDate birthDate, ContactData contactData) {
        super(firstName, lastName, birthDate, contactData);
        this.reports = new ArrayList<>();
    }

    @Override
    protected double calculateBonus() {
        if(getApprovedReports().size() >= AccountingDepartment.FINANCE_REPORTS_NEEDED_FOR_PERFORMANCE_BONUS){
            return TravelAgency.PERFORMANCE_BONUS;
        }
        return 0.0;
    }

    private Collection<FinancialReport> getApprovedReports(){
        List<FinancialReport> result = new LinkedList<>();
        for(FinancialReport report : reports) {
            if(report.isApproved()) result.add(report);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Accountant)) return false;
        Accountant other = (Accountant) o;

        return super.equals(o) && Objects.equals(reports, other.reports);
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 31 * hash + Objects.hashCode(reports);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Accountant{");
        sb.append("fullName=").append(fullName());
        sb.append(", occupation='").append(getOccupation()).append('\'');
        sb.append(", reports=").append(reports);
        sb.append('}');
        return sb.toString();
    }
}
