package com.solvd.laba.travelagency.model.booking.transport;

import com.solvd.laba.travelagency.model.finance.Currency;
import com.solvd.laba.travelagency.model.location.Address;
import com.solvd.laba.travelagency.model.person.Client;

import java.util.List;
import java.util.Objects;

public class CompositeTransportation extends Transportation {
    private List<Transportation> transportations;

    private CompositeTransportation(Address startLocation, Address endLocation, double price, Currency currency, List<Transportation> transportations) {
        super(startLocation, endLocation, price, currency);
        this.transportations = transportations;
    }

    @Override
    public void book(Client client) {
        super.book(client);
        transportations.forEach(t -> t.book(client));
    }

    @Override
    public void cancelBooking() {
        super.cancelBooking();
        transportations.forEach(Transportation::cancelBooking);
    }

    public static CompositeTransportation ofTransportations(List<Transportation> transportations){
        if(transportations.size() < 2){
            throw new IllegalArgumentException("At least 2 transportations required for composite transportation");
        }
        Address startLocation = transportations.get(0).getStartLocation();
        Address endLocation = transportations.get(transportations.size() - 1).getEndLocation();
        double price = transportations.stream()
                .map(Transportation::getPrice)
                .reduce(0.0, Double::sum);
        return new CompositeTransportation(startLocation, endLocation, price, null, transportations);
    }

    public List<Transportation> getTransportations() {
        return transportations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompositeTransportation)) return false;
        CompositeTransportation other = (CompositeTransportation) o;

        return super.equals(o) && Objects.equals(transportations, other.transportations);
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 31 * hash + transportations.hashCode();
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CompositeTransportation{");
        sb.append("transportations=").append(transportations);
        sb.append('}');
        return sb.toString();
    }
}
