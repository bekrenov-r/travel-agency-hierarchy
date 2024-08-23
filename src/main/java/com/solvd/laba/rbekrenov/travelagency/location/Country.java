package com.solvd.laba.rbekrenov.travelagency.location;

public final class Country {
    public static final Country FRANCE = new Country("France", "FR");
    public static final Country ITALY = new Country("Italy", "IT");
    public static final Country USA = new Country("USA", "US");
    public static final Country SPAIN = new Country("Spain", "ES");
    public static final Country GREAT_BRITAIN = new Country("Great Britain", "GB");
    private final String name;
    private final String countryCode;

    private Country(String name, String countryCode) {
        this.name = name;
        this.countryCode = countryCode;
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Country{");
        sb.append("name='").append(name).append('\'');
        sb.append(", countryCode='").append(countryCode).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
