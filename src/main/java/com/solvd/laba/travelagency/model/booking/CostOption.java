package com.solvd.laba.travelagency.model.booking;

public enum CostOption {
    ACCOMMODATION("Accommodation"),
    TRANSPORTATION("Transportation"),
    FOOD("Food");

    private final String name;

    CostOption(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
