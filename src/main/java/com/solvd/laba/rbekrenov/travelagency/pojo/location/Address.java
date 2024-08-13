package com.solvd.laba.rbekrenov.travelagency.pojo.location;

import java.util.UUID;

public class Address {
    private UUID id;
    private String city;
    private String street;
    private String buildingNumber;
    private String roomNumber;

    public Address(String city, String street, String buildingNumber, String roomNumber) {
        this.id = UUID.randomUUID();
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.roomNumber = roomNumber;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
}
