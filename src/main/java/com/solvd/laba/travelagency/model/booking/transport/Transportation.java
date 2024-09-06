package com.solvd.laba.travelagency.model.booking.transport;

import com.solvd.laba.travelagency.exception.AlreadyBookedException;
import com.solvd.laba.travelagency.model.booking.Bookable;
import com.solvd.laba.travelagency.model.finance.Payable;
import com.solvd.laba.travelagency.model.location.Address;
import com.solvd.laba.travelagency.model.person.Client;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Transportation implements Bookable, Payable {
    private Address startLocation;
    private Address endLocation;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private double price;
    private boolean isBooked;
    private Client bookedBy;
    private boolean isPaid;

    public Transportation(Address startLocation, Address endLocation, double price) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.price = price;
    }

    public Transportation(Address startLocation, Address endLocation, double price, LocalDateTime startTime, LocalDateTime endTime) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
    }

    @Override
    public void book(Client client) {
        if(this.isBooked) throw new AlreadyBookedException();
        this.isBooked = true;
        this.bookedBy = client;
    }

    @Override
    public void cancelBooking() {
        this.isBooked = false;
        this.bookedBy = null;
    }

    @Override
    public Client bookedBy() {
        return bookedBy;
    }

    @Override
    public boolean isPaid() {
        return this.isPaid;
    }

    @Override
    public void setPaid(boolean paid) {
        this.isPaid = paid;
    }

    public Address getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(Address startLocation) {
        this.startLocation = startLocation;
    }

    public Address getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(Address endLocation) {
        this.endLocation = endLocation;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public boolean isBooked() {
        return isBooked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transportation)) return false;
        Transportation other = (Transportation) o;

        return Objects.equals(bookedBy, other.bookedBy) && (Objects.equals(price, other.price))
                && (isBooked == other.isBooked)
                && (isPaid == other.isPaid)
                && (Objects.equals(startLocation, other.startLocation))
                && (Objects.equals(endLocation, other.endLocation))
                && (Objects.equals(startTime, other.startTime))
                && (Objects.equals(endTime, other.endTime));
    }

    @Override
    public int hashCode() {
        int hash = Objects.hashCode(startLocation);
        hash = 31 * hash + Objects.hashCode(endLocation);
        hash = 31 * hash + Objects.hashCode(startTime);
        hash = 31 * hash + Objects.hashCode(endTime);
        hash = 31 * hash + Objects.hashCode(price);
        hash = 31 * hash + (isBooked ? 1 : 0);
        hash = 31 * hash + Objects.hashCode(bookedBy);
        hash = 31 * hash + (isPaid ? 1 : 0);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Transportation{");
        sb.append("startLocation=").append(startLocation);
        sb.append(", endLocation=").append(endLocation);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
