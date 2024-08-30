package com.solvd.laba.rbekrenov.travelagency.service;

import com.solvd.laba.rbekrenov.travelagency.model.person.Client;
import com.solvd.laba.rbekrenov.travelagency.model.person.employee.Employee;

public class TravelAgencyService {
    public int calculateAverageEmployeeAge(Employee[] employees) {
        if(employees.length == 0) throw new IllegalArgumentException("Cannot calculate average age for empty list of employees");
        int sum = 0;
        for(Employee e : employees){
            sum += e.getAgeYears();
        }
        return sum / employees.length;
    }

    public int calculateAverageClientAge(Client[] clients) {
        if(clients.length == 0) throw new IllegalArgumentException("Cannot calculate average age for empty list of employees");
        int sum = 0;
        for(Client c : clients){
            sum += c.getAgeYears();
        }
        return sum / clients.length;
    }
}
