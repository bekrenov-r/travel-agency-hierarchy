package com.solvd.laba.travelagency.model.person.employee;

import com.solvd.laba.travelagency.model.TravelAgency;
import com.solvd.laba.travelagency.model.contract.TripContract;
import com.solvd.laba.travelagency.model.department.SalesDepartment;
import com.solvd.laba.travelagency.model.person.ContactData;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Salesman extends Employee {
    private List<TripContract> tripContracts;

    public Salesman(String firstName, String lastName, LocalDate birthDate) {
        super(firstName, lastName, birthDate);
        this.tripContracts = new ArrayList<>();
    }

    public Salesman(String firstName, String lastName, LocalDate birthDate, ContactData contactData) {
        super(firstName, lastName, birthDate, contactData);
        this.tripContracts = new ArrayList<>();
    }

    @Override
    protected double calculateBonus() {
        if (tripContracts.size() >= SalesDepartment.TRIP_CONTRACTS_NEEDED_FOR_PERFORMANCE_BONUS) {
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
        tripContracts.add(contract);
    }

    public List<TripContract> getTripContracts() {
        return tripContracts;
    }

    public void setTripContracts(List<TripContract> tripContracts) {
        this.tripContracts = tripContracts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Salesman)) return false;
        Salesman other = (Salesman) o;

        return super.equals(o) && Objects.equals(tripContracts, other.tripContracts);
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 31 * hash + Objects.hashCode(tripContracts);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Salesman{");
        sb.append("fullName=").append(fullName());
        sb.append(", occupation='").append(getOccupation()).append('\'');
        sb.append(", tripContracts=").append(tripContracts);
        sb.append('}');
        return sb.toString();
    }
}
