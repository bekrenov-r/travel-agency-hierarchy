package com.solvd.laba.travelagency.model.location;

import java.util.Objects;

public class Attraction {
    private String name;
    private Address address;

    public Attraction(String name) {
        this.name = name;
    }

    public Attraction(String name, Address address) {
        this.name = name;
        this.address = address;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Attraction)) return false;
        Attraction other = (Attraction) o;

        return Objects.equals(name, other.name) && Objects.equals(address, other.address);
    }

    @Override
    public int hashCode() {
        int hash = Objects.hashCode(name);
        hash = 31 * hash + Objects.hashCode(address);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Attraction{");
        sb.append("name='").append(name).append('\'');
        sb.append(", address=").append(address);
        sb.append('}');
        return sb.toString();
    }
}
