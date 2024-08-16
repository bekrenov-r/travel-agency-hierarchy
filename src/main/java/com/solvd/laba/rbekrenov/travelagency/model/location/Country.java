package com.solvd.laba.rbekrenov.travelagency.model.location;

import java.util.Objects;

public final class Country {
    public static final Country FRANCE = new Country("France", "FR");
    public static final Country ITALY = new Country("Italy", "IT");
    public static final Country USA = new Country("USA", "US");
    public static final Country SPAIN = new Country("Spain", "ES");
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;
        Country other = (Country) o;

        return Objects.equals(name, other.name) && Objects.equals(countryCode, other.countryCode);
    }

    @Override
    public int hashCode() {
        int hash = Objects.hashCode(name);
        hash = 31 * hash + Objects.hashCode(countryCode);
        return hash;
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
