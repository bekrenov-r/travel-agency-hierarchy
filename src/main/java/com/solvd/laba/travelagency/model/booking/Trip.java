package com.solvd.laba.travelagency.model.booking;

import com.solvd.laba.travelagency.exception.AlreadyBookedException;
import com.solvd.laba.travelagency.model.booking.transport.Transportation;
import com.solvd.laba.travelagency.model.finance.Payable;
import com.solvd.laba.travelagency.model.location.Destination;
import com.solvd.laba.travelagency.model.person.Client;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Trip implements Bookable, Payable {
    private String name;
    private Destination destination;
    private Transportation transportation;
    private double totalCost;
    private Map<String, Double> costDetails;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isPaid;
    private boolean isBooked;
    private Client bookedBy;

    public Trip(String name, Destination destination) {
        this.name = name;
        this.destination = destination;
        this.costDetails = new HashMap<>();
        this.totalCost = calculateTotalCost(costDetails);
    }

    public Trip(String name, Destination destination, Map<String, Double> costDetails, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.destination = destination;
        this.costDetails = costDetails;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalCost = calculateTotalCost(costDetails);
    }

    public int getDurationDays() {
        return (int) startDate.datesUntil(endDate).count();
    }

    private double calculateTotalCost(Map<String, Double> costDetails) {
        double result = 0.0;
        for (Map.Entry<String, Double> entry : costDetails.entrySet()) {
            result += entry.getValue();
        }
        return result;
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

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public Map<String, Double> getCostDetails() {
        return costDetails;
    }

    public void setCostDetails(Map<String, Double> costDetails) {
        this.costDetails = costDetails;
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
        return isPaid;
    }

    @Override
    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    @Override
    public double getPrice() {
        return totalCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trip)) return false;
        Trip other = (Trip) o;

        return Objects.equals(totalCost, other.totalCost) && Objects.equals(name, other.name)
                && Objects.equals(destination, other.destination)
                && Objects.equals(transportation, other.transportation)
                && Objects.equals(costDetails, other.costDetails)
                && Objects.equals(startDate, other.startDate)
                && Objects.equals(endDate, other.endDate)
                && (isPaid == other.isPaid)
                && (isBooked == other.isBooked)
                && Objects.equals(bookedBy, other.bookedBy);
    }

    @Override
    public int hashCode() {
        int hash = Objects.hashCode(name);
        hash = 31 * hash + Objects.hashCode(destination);
        hash = 31 * hash + Objects.hashCode(transportation);
        hash = 31 * hash + Objects.hashCode(totalCost);
        hash = 31 * hash + Objects.hashCode(costDetails);
        hash = 31 * hash + Objects.hashCode(startDate);
        hash = 31 * hash + Objects.hashCode(endDate);
        hash = 31 * hash + (isBooked ? 1 : 0);
        hash = 31 * hash + (isPaid ? 1 : 0);
        hash = 31 * hash + Objects.hashCode(bookedBy);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Trip{");
        sb.append("name='").append(name).append('\'');
        sb.append(", destination=").append(destination);
        sb.append(", transportation=").append(transportation);
        sb.append(", totalCost=").append(totalCost);
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", isBooked=").append(isBooked);
        sb.append(", isPaid=").append(isPaid);
        sb.append(", bookedBy=").append(bookedBy);
        sb.append('}');
        return sb.toString();
    }
}
