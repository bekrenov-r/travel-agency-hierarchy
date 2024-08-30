package com.solvd.laba.rbekrenov.travelagency.model.booking.transport;

public class FlightCompany {
    public static final FlightCompany RYAN_AIR = new FlightCompany("Ryan Air");
    public static final FlightCompany EMIRATES = new FlightCompany("Emirates");
    public static final FlightCompany WIZZ_AIR = new FlightCompany("Wizz Air");
    private final String name;
    private FlightCompany(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
