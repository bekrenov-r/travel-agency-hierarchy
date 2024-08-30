package com.solvd.laba.rbekrenov.travelagency.model.booking.transport;

import com.solvd.laba.rbekrenov.travelagency.model.location.Address;

import java.time.LocalDateTime;
import java.util.Objects;

public class BusTransportation extends Transportation {
    private String busNumber;

    public BusTransportation(Address startLocation, Address endLocation, double price, String busNumber) {
        super(startLocation, endLocation, price);
        this.busNumber = busNumber;
    }

    public BusTransportation(
            Address startLocation, Address endLocation, double price,
            LocalDateTime startTime, LocalDateTime endTime, String busNumber) {
        super(startLocation, endLocation, price, startTime, endTime);
        this.busNumber = busNumber;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BusTransportation)) return false;
        BusTransportation other = (BusTransportation) o;

        return super.equals(o) && Objects.equals(busNumber, other.busNumber);
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 31 * hash + Objects.hashCode(busNumber);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("BusTransportation{");
        sb.append("busNumber='").append(busNumber).append('\'');
        sb.append(", startLocation=").append(getStartLocation());
        sb.append(", endLocation=").append(getEndLocation());
        sb.append(", startTime=").append(getStartTime());
        sb.append(", endTime=").append(getEndTime());
        sb.append(", price=").append(getPrice());
        sb.append('}');
        return sb.toString();
    }
}
