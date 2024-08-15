package com.solvd.laba.rbekrenov.travelagency.model;

import com.solvd.laba.rbekrenov.travelagency.model.location.Address;

public class Attraction {
    private String name;
    private Address address;

    public Attraction(String name) {
        this.name = name;
    }

    public Attraction(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
