package com.solvd.laba.rbekrenov.travelagency.pojo;

import com.solvd.laba.rbekrenov.travelagency.pojo.location.Country;

import java.util.UUID;

public class Destination {
    private UUID id;
    private Country country;
    private String city;
    private Attraction[] attractions;

    public Destination(Country country, String city, Attraction[] attractions) {
        this.id = UUID.randomUUID();
        this.country = country;
        this.city = city;
        this.attractions = attractions;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Attraction[] getAttractions() {
        return attractions;
    }

    public void setAttractions(Attraction[] attractions) {
        this.attractions = attractions;
    }
}
