package com.solvd.laba.rbekrenov.travelagency.model.person.employee;

import com.solvd.laba.rbekrenov.travelagency.model.TravelAgency;
import com.solvd.laba.rbekrenov.travelagency.model.contract.JobContract;
import com.solvd.laba.rbekrenov.travelagency.model.department.HumanResourcesDepartment;
import com.solvd.laba.rbekrenov.travelagency.model.person.ContactData;

import java.time.LocalDate;
import java.util.Arrays;

public class HRManager extends Employee {
    private JobContract[] jobContracts;

    public HRManager(String firstName, String lastName, LocalDate birthDate) {
        super(firstName, lastName, birthDate);
        this.jobContracts = new JobContract[]{};
    }

    public HRManager(String firstName, String lastName, LocalDate birthDate, ContactData contactData) {
        super(firstName, lastName, birthDate, contactData);
        this.jobContracts = new JobContract[]{};
    }

    @Override
    protected double calculateBonus() {
        if(jobContracts.length >= HumanResourcesDepartment.EMPLOYMENTS_NEEDED_FOR_PERFORMANCE_BONUS){
            return TravelAgency.PERFORMANCE_BONUS;
        }
        return 0.0;
    }

    public void addJobContract(JobContract jobContract){
        JobContract[] jobContractsNew = new JobContract[jobContracts.length + 1];
        for(int i = 0; i < jobContracts.length; i++){
            jobContractsNew[i] = jobContracts[i];
        }
        jobContractsNew[jobContractsNew.length - 1] = jobContract;
        setJobContracts(jobContractsNew);
    }

    public JobContract[] getJobContracts() {
        return jobContracts;
    }

    public void setJobContracts(JobContract[] jobContracts) {
        this.jobContracts = jobContracts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HRManager)) return false;
        HRManager other = (HRManager) o;

        return super.equals(o) && Arrays.equals(jobContracts, other.jobContracts);
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 31 * hash + Arrays.hashCode(jobContracts);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("HRManager{");
        sb.append("fullName=").append(fullName());
        sb.append(", occupation='").append(getOccupation()).append('\'');
        sb.append(", jobContracts=").append(Arrays.toString(jobContracts));
        sb.append('}');
        return sb.toString();
    }
}
