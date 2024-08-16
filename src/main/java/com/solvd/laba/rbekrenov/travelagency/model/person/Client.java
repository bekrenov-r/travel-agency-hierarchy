package com.solvd.laba.rbekrenov.travelagency.model.person;

import com.solvd.laba.rbekrenov.travelagency.model.location.Address;
import com.solvd.laba.rbekrenov.travelagency.model.person.Person;

import java.time.LocalDate;

public class Client extends Person {
    public Client(String firstName, String lastName, String phoneNumber, LocalDate birthDate) {
        super(firstName, lastName, phoneNumber, birthDate);
    }

    public Client(String firstName, String lastName, String email, String phoneNumber, LocalDate birthDate, Address address) {
        super(firstName, lastName, email, phoneNumber, birthDate, address);
    }
}
