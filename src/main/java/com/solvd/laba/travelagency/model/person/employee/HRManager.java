package com.solvd.laba.travelagency.model.person.employee;

import com.solvd.laba.travelagency.model.TravelAgency;
import com.solvd.laba.travelagency.model.contract.JobContract;
import com.solvd.laba.travelagency.model.department.HumanResourcesDepartment;
import com.solvd.laba.travelagency.model.person.ContactData;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HRManager extends Employee {
    private List<JobContract> jobContracts;

    public HRManager(String firstName, String lastName, LocalDate birthDate) {
        super(firstName, lastName, birthDate);
        this.jobContracts = new ArrayList<>();
    }

    public HRManager(String firstName, String lastName, LocalDate birthDate, ContactData contactData) {
        super(firstName, lastName, birthDate, contactData);
        this.jobContracts = new ArrayList<>();
    }

    @Override
    protected double calculateBonus() {
        return jobContracts.size() >= HumanResourcesDepartment.EMPLOYMENTS_NEEDED_FOR_PERFORMANCE_BONUS
                ? TravelAgency.PERFORMANCE_BONUS : 0.0;
    }

    public void addJobContract(JobContract jobContract){
        jobContracts.add(jobContract);
    }

    public List<JobContract> getJobContracts() {
        return jobContracts;
    }

    public void setJobContracts(List<JobContract> jobContracts) {
        this.jobContracts = jobContracts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HRManager)) return false;
        HRManager other = (HRManager) o;

        return super.equals(o) && Objects.equals(jobContracts, other.jobContracts);
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 31 * hash + Objects.hashCode(jobContracts);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("HRManager{");
        sb.append("fullName=").append(fullName());
        sb.append(", occupation='").append(getOccupation()).append('\'');
        sb.append(", jobContracts=").append(jobContracts);
        sb.append('}');
        return sb.toString();
    }
}
