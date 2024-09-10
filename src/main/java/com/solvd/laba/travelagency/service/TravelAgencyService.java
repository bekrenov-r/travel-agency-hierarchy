package com.solvd.laba.travelagency.service;

import com.solvd.laba.travelagency.model.person.Client;
import com.solvd.laba.travelagency.model.person.employee.Employee;

import java.util.Collection;

public class TravelAgencyService {
    public int calculateAverageEmployeeAge(Collection<Employee> employees) {
        if(employees.size() == 0) {
            throw new IllegalArgumentException("Cannot calculate average age for empty list of employees");
        }
        int sum = 0;
        for(Employee e : employees){
            sum += e.getAgeYears();
        }
        return sum / employees.size();
    }

    public int calculateAverageClientAge(Collection<Client> clients) {
        if(clients.size() == 0) {
            throw new IllegalArgumentException("Cannot calculate average age for empty list of employees");
        }
        int sum = 0;
        for(Client c : clients){
            sum += c.getAgeYears();
        }
        return sum / clients.size();
    }
}
