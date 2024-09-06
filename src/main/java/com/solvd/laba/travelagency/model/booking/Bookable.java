package com.solvd.laba.travelagency.model.booking;

import com.solvd.laba.travelagency.model.person.Client;

public interface Bookable {
    boolean isBooked();
    void book(Client client);
    void cancelBooking();
    Client bookedBy();
}
