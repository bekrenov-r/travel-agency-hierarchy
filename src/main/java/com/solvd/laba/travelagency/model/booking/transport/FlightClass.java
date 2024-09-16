package com.solvd.laba.travelagency.model.booking.transport;

public enum FlightClass {
    BUSINESS_CLASS("Business class"),
    FIRST_CLASS("First class"),
    SECOND_CLASS("Second class"),
    ECONOMY_CLASS("Economy class");

    private final String name;

    FlightClass(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
