package com.solvd.laba.travelagency.model.booking.transport;

public final class FlightClass {
    public static final FlightClass BUSINESS_CLASS = new FlightClass("Business class");
    public static final FlightClass FIRST_CLASS = new FlightClass("First class");
    public static final FlightClass SECOND_CLASS = new FlightClass("Second class");
    public static final FlightClass ECONOMY_CLASS = new FlightClass("Economy class");
    private final String name;
    private FlightClass(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
