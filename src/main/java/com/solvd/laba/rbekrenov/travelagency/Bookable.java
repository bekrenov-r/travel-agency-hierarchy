package com.solvd.laba.rbekrenov.travelagency;

import com.solvd.laba.rbekrenov.travelagency.person.Client;

public interface Bookable {
    boolean isBooked();
    void book(Client client);
    void cancelBooking();
    Client bookedBy();
}
