package com.solvd.laba.rbekrenov.travelagency.model.person.employee;

import com.solvd.laba.rbekrenov.travelagency.model.FinancialReport;
import com.solvd.laba.rbekrenov.travelagency.model.TravelAgency;
import com.solvd.laba.rbekrenov.travelagency.model.department.AccountingDepartment;

import java.time.LocalDate;
import java.util.Arrays;

public class Accountant extends Employee {
    private FinancialReport[] reports;

    public Accountant(String firstName, String lastName, String phoneNumber, LocalDate birthDate) {
        super(firstName, lastName, phoneNumber, birthDate);
        this.reports = new FinancialReport[]{};
    }

    @Override
    protected double calculateBonus() {
        if(getApprovedReports().length >= AccountingDepartment.FINANCE_REPORTS_NEEDED_FOR_PERFORMANCE_BONUS){
            return TravelAgency.PERFORMANCE_BONUS;
        }
        return 0.0;
    }

    private FinancialReport[] getApprovedReports(){
        int approvedReportsQuantity = 0;
        for(FinancialReport report : reports){
            if(report.isApproved()) approvedReportsQuantity++;
        }
        FinancialReport[] approvedReports = new FinancialReport[approvedReportsQuantity];
        int index = 0;
        for(FinancialReport report : reports){
            if(report.isApproved()){
                approvedReports[index] = report;
                index++;
            }
        }
        return approvedReports;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Accountant)) return false;
        Accountant other = (Accountant) o;

        return super.equals(o) && Arrays.equals(reports, other.reports);
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 31 * hash + Arrays.hashCode(reports);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Accountant{");
        sb.append("fullName=").append(fullName());
        sb.append(", occupation='").append(getOccupation()).append('\'');
        sb.append(", reports=").append(Arrays.toString(reports));
        sb.append('}');
        return sb.toString();
    }
}
