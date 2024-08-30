package com.solvd.laba.rbekrenov.travelagency.model.booking.transport;

import com.solvd.laba.rbekrenov.travelagency.model.location.Address;
import com.solvd.laba.rbekrenov.travelagency.model.person.Client;

import java.util.Arrays;

public class CompositeTransportation extends Transportation {
    private Transportation[] transportations;

    private CompositeTransportation(Address startLocation, Address endLocation, double price) {
        super(startLocation, endLocation, price);
    }

    @Override
    public void book(Client client) {
        super.book(client);
        for(Transportation t : transportations){
            t.book(client);
        }
    }

    @Override
    public void cancelBooking() {
        super.cancelBooking();
        for(Transportation t : transportations){
            t.cancelBooking();
        }
    }

    public static CompositeTransportation ofTransportations(Transportation[] transportations){
        if(transportations.length < 2){
            throw new IllegalArgumentException("At least 2 transportations required for composite transportation");
        }
        Address startLocation = transportations[0].getStartLocation();
        Address endLocation = transportations[transportations.length-1].getEndLocation();
        double price = 0.0;
        for(Transportation t : transportations) {
            price += t.getPrice();
        }
        return new CompositeTransportation(startLocation, endLocation, price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompositeTransportation)) return false;
        CompositeTransportation other = (CompositeTransportation) o;

        return super.equals(o) && Arrays.equals(transportations, other.transportations);
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 31 * hash + Arrays.hashCode(transportations);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CompositeTransportation{");
        sb.append("transportations=").append(Arrays.toString(transportations));
        sb.append('}');
        return sb.toString();
    }
}
