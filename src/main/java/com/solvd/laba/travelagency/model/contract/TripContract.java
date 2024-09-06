package com.solvd.laba.travelagency.model.contract;

import com.solvd.laba.travelagency.model.booking.Trip;
import com.solvd.laba.travelagency.model.person.Client;
import com.solvd.laba.travelagency.model.person.employee.Salesman;

import java.util.Objects;

public class TripContract extends Contract {
    private Trip trip;
    private Client client;
    private Salesman salesman;

    public TripContract(Trip trip) {
        this.trip = trip;
    }

    public TripContract(Salesman salesman, Client client, Trip trip) {
        this.salesman = salesman;
        this.client = client;
        this.trip = trip;
    }

    @Override
    public void sign() {
        super.sign();
        salesman.addTripContract(this);
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof TripContract)) return false;
        TripContract other = (TripContract) o;

        return super.equals(other) && Objects.equals(trip, other.trip)
                && Objects.equals(client, other.client)
                && Objects.equals(salesman, other.salesman);
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 37 * hash + (getSignedDate() == null ? 0 : getSignedDate().hashCode());
        hash = 37 * hash + (trip == null ? 0 : trip.hashCode());
        hash = 37 * hash + (client == null ? 0 : client.hashCode());
        hash = 37 * hash + (salesman == null ? 0 : salesman.hashCode());
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TripContract{");
        sb.append("trip=").append(trip.getName());
        sb.append(", client=").append(client.fullName());
        sb.append(", salesman=").append(salesman.fullName());
        sb.append('}');
        return sb.toString();
    }
}
