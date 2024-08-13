package com.solvd.laba.rbekrenov.travelagency.pojo;

import java.time.LocalDate;
import java.util.UUID;

public class Contract {
    private UUID id;
    private LocalDate signedDate;
    private Employee employee;
    private Client client;
    private Trip trip;

    public Contract(LocalDate signedDate, Employee employee, Client client, Trip trip) {
        this.id = UUID.randomUUID();
        this.signedDate = signedDate;
        this.employee = employee;
        this.client = client;
        this.trip = trip;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
