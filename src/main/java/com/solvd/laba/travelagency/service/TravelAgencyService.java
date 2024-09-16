package com.solvd.laba.travelagency.service;

import com.solvd.laba.travelagency.model.person.Person;

import java.util.Collection;

public class TravelAgencyService {
    public int calculateAverageAge(Collection<? extends Person> people) {
        double average = people.stream()
                .mapToInt(Person::getAgeYears)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("Employees collection cannot be empty"));
        return (int) average;
    }
}
