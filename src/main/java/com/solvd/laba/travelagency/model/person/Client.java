package com.solvd.laba.travelagency.model.person;

import com.solvd.laba.travelagency.model.booking.Trip;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client extends Person {
    private static final int TRIPS_REQUIRED_FOR_REGULAR_CUSTOMER_STATUS = 5;
    private List<Trip> trips;

    public Client(String firstName, String lastName, LocalDate birthDate) {
        super(firstName, lastName, birthDate);
        this.trips = new ArrayList<>();
    }

    public Client(String firstName, String lastName, LocalDate birthDate, ContactData contactData) {
        super(firstName, lastName, birthDate, contactData);
        this.trips = new ArrayList<>();
    }

    public boolean isRegularCustomer() {
        return trips.size() > TRIPS_REQUIRED_FOR_REGULAR_CUSTOMER_STATUS;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client other = (Client) o;

        return super.equals(o) && Objects.equals(trips, other.trips);
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 31 * hash + Objects.hashCode(trips);
        return hash;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
