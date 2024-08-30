package com.solvd.laba.rbekrenov.travelagency.model.booking;

import com.solvd.laba.rbekrenov.travelagency.model.person.Client;

public interface Bookable {
    boolean isBooked();
    void book(Client client);
    void cancelBooking();
    Client bookedBy();
}
