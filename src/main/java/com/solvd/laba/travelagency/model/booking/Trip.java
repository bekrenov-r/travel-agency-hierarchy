package com.solvd.laba.travelagency.model.booking;

import com.solvd.laba.travelagency.exception.AlreadyBookedException;
import com.solvd.laba.travelagency.model.booking.transport.Transportation;
import com.solvd.laba.travelagency.model.finance.Currency;
import com.solvd.laba.travelagency.model.finance.Payable;
import com.solvd.laba.travelagency.model.location.Destination;
import com.solvd.laba.travelagency.model.person.Client;

import java.time.LocalDate;
import java.util.Objects;

public class Trip implements Bookable, Payable {
    private String name;
    private Destination destination;
    private Transportation transportation;
    private LocalDate startDate;
    private LocalDate endDate;
    private PaymentDetails paymentDetails;
    private boolean isBooked;
    private Client bookedBy;

    public Trip(String name, Destination destination) {
        this.name = name;
        this.destination = destination;
    }

    public Trip(String name, Destination destination, PaymentDetails paymentDetails, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.destination = destination;
        this.paymentDetails = paymentDetails;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getDurationDays() {
        return (int) startDate.datesUntil(endDate).count();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Transportation getTransportation() {
        return transportation;
    }

    public void setTransportation(Transportation transportation) {
        this.transportation = transportation;
    }

    @Override
    public boolean isBooked() {
        return this.isBooked;
    }

    @Override
    public void book(Client client) {
        if(this.isBooked) {
            throw new AlreadyBookedException();
        }
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
        return paymentDetails.isPaid();
    }

    @Override
    public void setPaid(boolean paid) {
        paymentDetails.setPaid(paid);
    }

    @Override
    public double getPrice() {
        return paymentDetails.getPrice();
    }

    @Override
    public Currency getCurrency() {
        return paymentDetails.getCurrency();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trip trip)) return false;

        if (isBooked != trip.isBooked) return false;
        if (!Objects.equals(name, trip.name)) return false;
        if (!Objects.equals(destination, trip.destination)) return false;
        if (!Objects.equals(transportation, trip.transportation))
            return false;
        if (!Objects.equals(startDate, trip.startDate)) return false;
        if (!Objects.equals(endDate, trip.endDate)) return false;
        if (!Objects.equals(paymentDetails, trip.paymentDetails))
            return false;
        return Objects.equals(bookedBy, trip.bookedBy);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        result = 31 * result + (transportation != null ? transportation.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (paymentDetails != null ? paymentDetails.hashCode() : 0);
        result = 31 * result + (isBooked ? 1 : 0);
        result = 31 * result + (bookedBy != null ? bookedBy.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Trip{");
        sb.append("name='").append(name).append('\'');
        sb.append(", destination=").append(destination);
        sb.append(", transportation=").append(transportation);
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", paymentDetails=").append(paymentDetails);
        sb.append(", isBooked=").append(isBooked);
        sb.append(", bookedBy=").append(bookedBy);
        sb.append('}');
        return sb.toString();
    }
}
