package com.solvd.laba.travelagency.model.booking.transport;

import com.solvd.laba.travelagency.model.finance.Currency;
import com.solvd.laba.travelagency.model.location.Address;

import java.time.LocalDateTime;
import java.util.Objects;

public class Flight extends Transportation {
    private FlightCompany flightCompany;
    private FlightClass flightClass;
    private String number;

    public Flight(
            Address startLocation, Address endLocation, double price, Currency currency,
            LocalDateTime startTime, LocalDateTime endTime, String number) {
        super(startLocation, endLocation, price, currency, startTime, endTime);
        this.number = number;
    }

    public FlightCompany getFlightCompany() {
        return flightCompany;
    }

    public void setFlightCompany(FlightCompany flightCompany) {
        this.flightCompany = flightCompany;
    }

    public FlightClass getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(FlightClass flightClass) {
        this.flightClass = flightClass;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        Flight other = (Flight) o;

        return super.equals(o) && Objects.equals(number, other.number)
                && Objects.equals(flightCompany, other.flightCompany)
                && Objects.equals(flightClass, other.flightClass);
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 31 * hash + Objects.hashCode(flightCompany);
        hash = 31 * hash + Objects.hashCode(flightClass);
        hash = 31 * hash + Objects.hashCode(number);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Flight{");
        sb.append("flightCompany=").append(flightCompany);
        sb.append(", flightClass=").append(flightClass);
        sb.append(", number='").append(number).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
