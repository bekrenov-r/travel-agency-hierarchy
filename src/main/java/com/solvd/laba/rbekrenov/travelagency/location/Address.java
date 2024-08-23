package com.solvd.laba.rbekrenov.travelagency.location;

import java.util.Objects;

public class Address {
    private Country country;
    private String city;
    private String street;
    private String buildingNumber;
    private String roomNumber;
    private String zipCode;

    public Address(Country country, String city, String street, String buildingNumber, String zipCode) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.zipCode = zipCode;
    }

    public Address(Country country, String city, String street, String buildingNumber, String roomNumber, String zipCode) {
        this.country = country;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address other = (Address) o;

        return Objects.equals(country, other.country) && Objects.equals(city, other.city)
                && Objects.equals(street, other.street)
                && Objects.equals(buildingNumber, other.buildingNumber)
                && Objects.equals(roomNumber, other.roomNumber)
                && Objects.equals(zipCode, other.zipCode);
    }

    @Override
    public int hashCode() {
        int hash = Objects.hashCode(country);
        hash = 31 * hash + Objects.hashCode(city);
        hash = 31 * hash + Objects.hashCode(street);
        hash = 31 * hash + Objects.hashCode(buildingNumber);
        hash = 31 * hash + Objects.hashCode(roomNumber);
        hash = 31 * hash + Objects.hashCode(zipCode);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Address{");
        sb.append("country='").append(country.getName()).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", street='").append(street).append('\'');
        sb.append(", buildingNumber='").append(buildingNumber).append('\'');
        sb.append(", roomNumber='").append(roomNumber).append('\'');
        sb.append(", zipCode='").append(zipCode).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
