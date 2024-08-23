package com.solvd.laba.rbekrenov.travelagency.person;

import com.solvd.laba.rbekrenov.travelagency.Trip;
import com.solvd.laba.rbekrenov.travelagency.location.Address;

import java.time.LocalDate;
import java.util.Arrays;

public class Client extends Person {
    private static final int TRIPS_REQUIRED_FOR_REGULAR_CUSTOMER_STATUS = 5;
    private Trip[] trips;

    public Client(String firstName, String lastName, String phoneNumber, LocalDate birthDate) {
        super(firstName, lastName, phoneNumber, birthDate);
        this.trips = new Trip[]{};
    }

    public Client(String firstName, String lastName, String email, String phoneNumber, LocalDate birthDate, Address address) {
        super(firstName, lastName, email, phoneNumber, birthDate, address);
        this.trips = new Trip[]{};
    }

    public boolean isRegularCustomer() {
        return trips.length > TRIPS_REQUIRED_FOR_REGULAR_CUSTOMER_STATUS;
    }

    public Trip[] getTrips() {
        return trips;
    }

    public void setTrips(Trip[] trips) {
        this.trips = trips;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client other = (Client) o;

        return super.equals(o) && Arrays.equals(trips, other.trips);
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 31 * hash + Arrays.hashCode(trips);
        return hash;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
