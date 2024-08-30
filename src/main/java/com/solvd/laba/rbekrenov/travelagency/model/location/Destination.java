package com.solvd.laba.rbekrenov.travelagency.model.location;

import java.util.Arrays;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Destination)) return false;
        Destination other = (Destination) o;

        return Objects.equals(country, other.country) && Objects.equals(city, other.city)
                && Arrays.equals(attractions, other.attractions);
    }

    @Override
    public int hashCode() {
        int hash = Objects.hashCode(country);
        hash = 31 * hash + Objects.hashCode(city);
        hash = 31 * hash + Arrays.hashCode(attractions);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Destination{");
        sb.append("country=").append(country);
        sb.append(", city='").append(city).append('\'');
        sb.append(", attractions=").append(Arrays.toString(attractions));
        sb.append('}');
        return sb.toString();
    }
}
