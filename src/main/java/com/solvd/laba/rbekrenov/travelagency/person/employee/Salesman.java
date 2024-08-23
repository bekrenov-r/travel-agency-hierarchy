package com.solvd.laba.rbekrenov.travelagency.person.employee;

import com.solvd.laba.rbekrenov.travelagency.TravelAgency;
import com.solvd.laba.rbekrenov.travelagency.contract.TripContract;
import com.solvd.laba.rbekrenov.travelagency.department.SalesDepartment;

import java.time.LocalDate;
import java.util.Arrays;

public class Salesman extends Employee {
    private TripContract[] tripContracts;

    public Salesman(String firstName, String lastName, String phoneNumber, LocalDate birthDate) {
        super(firstName, lastName, phoneNumber, birthDate);
        this.tripContracts = new TripContract[]{};;
    }

    @Override
    protected double calculateBonus() {
        if (tripContracts.length >= SalesDepartment.TRIP_CONTRACTS_NEEDED_FOR_PERFORMANCE_BONUS) {
            return TravelAgency.PERFORMANCE_BONUS;
        }
        return 0.0;
    }

    public double calculateAllContractsGrossIncome(){
        double result = 0.0;
        for(TripContract tc : tripContracts) {
            result += tc.getTrip().getTotalCost();
        }
        return result;
    }

    public void addTripContract(TripContract contract) {
        TripContract[] contractsNew = new TripContract[tripContracts.length + 1];
        for(int i = 0; i < tripContracts.length; i++){
            contractsNew[i] = tripContracts[i];
        }
        contractsNew[contractsNew.length - 1] = contract;
        setTripContracts(contractsNew);
    }

    public TripContract[] getTripContracts() {
        return tripContracts;
    }

    public void setTripContracts(TripContract[] tripContracts) {
        this.tripContracts = tripContracts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Salesman)) return false;
        Salesman other = (Salesman) o;

        return super.equals(o) && Arrays.equals(tripContracts, other.tripContracts);
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 31 * hash + Arrays.hashCode(tripContracts);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Salesman{");
        sb.append("fullName=").append(fullName());
        sb.append(", occupation='").append(getOccupation()).append('\'');
        sb.append(", tripContracts=").append(Arrays.toString(tripContracts));
        sb.append('}');
        return sb.toString();
    }
}
