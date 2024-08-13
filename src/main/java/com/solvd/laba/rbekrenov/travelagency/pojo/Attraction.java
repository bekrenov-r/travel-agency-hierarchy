package com.solvd.laba.rbekrenov.travelagency.pojo;

import com.solvd.laba.rbekrenov.travelagency.pojo.location.Address;

import java.util.UUID;

public class Attraction {
    private UUID id;
    private String name;
    private Address address;

    public Attraction(String name, Address address) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.address = address;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
