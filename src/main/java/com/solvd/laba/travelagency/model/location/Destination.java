package com.solvd.laba.travelagency.model.location;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Destination {
    private Country country;
    private String city;
    private Set<Attraction> attractions;

    public Destination(Country country, String city) {
        this.country = country;
        this.city = city;
        this.attractions = new HashSet<>();
    }

    public Destination(Country country, String city, Set<Attraction> attractions) {
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

    public Set<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(Set<Attraction> attractions) {
        this.attractions = attractions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Destination)) return false;
        Destination other = (Destination) o;

        return Objects.equals(country, other.country) && Objects.equals(city, other.city)
                && Objects.equals(attractions, other.attractions);
    }

    @Override
    public int hashCode() {
        int hash = Objects.hashCode(country);
        hash = 31 * hash + Objects.hashCode(city);
        hash = 31 * hash + Objects.hashCode(attractions);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Destination{");
        sb.append("country=").append(country);
        sb.append(", city='").append(city).append('\'');
        sb.append(", attractions=").append(attractions);
        sb.append('}');
        return sb.toString();
    }
}
