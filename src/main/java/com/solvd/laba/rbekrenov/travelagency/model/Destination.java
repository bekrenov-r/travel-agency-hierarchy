package com.solvd.laba.rbekrenov.travelagency.model;

import com.solvd.laba.rbekrenov.travelagency.model.location.Country;

public class Destination {
    private Country country;
    private String city;
    private Attraction[] attractions;

    public Destination(Country country, String city) {
        this.country = country;
        this.city = city;
        this.attractions = new Attraction[]{};
    }

    public Destination(Country country, String city, Attraction[] attractions) {
        this.country = country;
        this.city = city;
        this.attractions = attractions;
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
