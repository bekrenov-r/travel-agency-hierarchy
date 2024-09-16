package com.solvd.laba.travelagency.model.booking.transport;

public enum FlightCompany {
    RYAN_AIR("Ryan Air"),
    EMIRATES("Emirates"),
    WIZZ_AIR("Wizz Air");

    private final String name;

    FlightCompany(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
