package com.solvd.laba.rbekrenov.travelagency.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Trip {
    private String name;
    private Destination destination;
    private double totalCost;
    private Map<String, Double> costDetails;
    private LocalDate startDate;
    private LocalDate endDate;

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
}
