package com.solvd.laba.rbekrenov.travelagency.model;

import java.time.LocalDate;

public class Contract {
    private LocalDate signedDate;
    private Employee employee;
    private Client client;
    private Trip trip;

    public Contract(Trip trip) {
        this.trip = trip;
    }

    public Contract(Employee employee, Client client, Trip trip) {
        this.employee = employee;
        this.client = client;
        this.trip = trip;
    }

    public Contract(LocalDate signedDate, Employee employee, Client client, Trip trip) {
        this.signedDate = signedDate;
        this.employee = employee;
        this.client = client;
        this.trip = trip;
    }

    public LocalDate getSignedDate() {
        return signedDate;
    }

    public void setSignedDate(LocalDate signedDate) {
        this.signedDate = signedDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }
}
