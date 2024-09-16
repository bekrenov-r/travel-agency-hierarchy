package com.solvd.laba.travelagency.model.booking.transport;

import com.solvd.laba.travelagency.model.finance.Currency;
import com.solvd.laba.travelagency.model.location.Address;

import java.time.LocalDateTime;
import java.util.Objects;

public class TrainTransportation extends Transportation {
    private String trainNumber;

    public TrainTransportation(
            Address startLocation, Address endLocation, double price, Currency currency,
            LocalDateTime startTime, LocalDateTime endTime, String trainNumber) {
        super(startLocation, endLocation, price, currency, startTime, endTime);
        this.trainNumber = trainNumber;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TrainTransportation)) return false;
        TrainTransportation other = (TrainTransportation) o;

        return super.equals(o) && Objects.equals(trainNumber, other.trainNumber);
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 31 * hash + Objects.hashCode(trainNumber);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TrainTransportation{");
        sb.append("trainNumber='").append(trainNumber).append('\'');
        sb.append(", startLocation=").append(getStartLocation());
        sb.append(", endLocation=").append(getEndLocation());
        sb.append(", startTime=").append(getStartTime());
        sb.append(", endTime=").append(getEndTime());
        sb.append(", price=").append(getPrice());
        sb.append('}');
        return sb.toString();
    }
}
