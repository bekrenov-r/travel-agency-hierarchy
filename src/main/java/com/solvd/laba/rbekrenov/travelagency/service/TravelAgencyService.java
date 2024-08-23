package com.solvd.laba.rbekrenov.travelagency.service;

import com.solvd.laba.rbekrenov.travelagency.person.Client;
import com.solvd.laba.rbekrenov.travelagency.person.employee.Employee;

public class TravelAgencyService {
    public int calculateAverageEmployeeAge(Employee[] employees) {
        int sum = 0;
        for(Employee e : employees){
            sum += e.getAgeYears();
        }
        return sum / employees.length;
    }

    public int calculateAverageClientAge(Client[] clients) {
        int sum = 0;
        for(Client c : clients){
            sum += c.getAgeYears();
        }
        return sum / clients.length;
    }
}
