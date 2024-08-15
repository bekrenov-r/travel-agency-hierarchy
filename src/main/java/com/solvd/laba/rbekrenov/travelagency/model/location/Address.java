package com.solvd.laba.rbekrenov.travelagency.model.location;

public class Address {
    private String city;
    private String street;
    private String buildingNumber;
    private String roomNumber;
    private String zipCode;

    public Address(String city, String street, String buildingNumber, String zipCode) {
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.zipCode = zipCode;
    }

    public Address(String city, String street, String buildingNumber, String roomNumber, String zipCode) {
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.roomNumber = roomNumber;
        this.zipCode = zipCode;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
