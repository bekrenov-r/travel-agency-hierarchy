package com.solvd.laba.rbekrenov.travelagency;

import com.solvd.laba.rbekrenov.travelagency.model.*;
import com.solvd.laba.rbekrenov.travelagency.model.location.Address;
import com.solvd.laba.rbekrenov.travelagency.model.location.Country;
import com.solvd.laba.rbekrenov.travelagency.service.TravelAgencyService;

import java.time.LocalDate;
import java.util.Map;

public class Main {
    private static final Destination[] DESTINATIONS = new Destination[]{
            new Destination(Country.getCountryByCode("FR"), "Paris"),
            new Destination(Country.getCountryByCode("FR"), "Nice"),
            new Destination(Country.getCountryByCode("IT"), "Rome"),
            new Destination(Country.getCountryByCode("IT"), "Milan"),
            new Destination(Country.getCountryByCode("US"), "New York"),
            new Destination(Country.getCountryByCode("ES"), "Barcelona")
    };

    public static void main(String[] args) {
        TravelAgency travelAgency = initTravelAgency();

        TravelAgencyService service = new TravelAgencyService(travelAgency);
        service.grantPerformanceBonusToEmployees();

        service.payAllBills();

        Department bestPerformingDepartment = travelAgency.getBestPerformingDepartment();
        System.out.printf("Best performing department: %s with %s contracts in total.\n", bestPerformingDepartment.getName(), bestPerformingDepartment.getTotalContractsCount());
        System.out.println("Gross income: £" + travelAgency.calculateGrossIncome());
    }

    private static TravelAgency initTravelAgency() {
        TravelAgency travelAgency = new TravelAgency("Treasure Island");

        Employee jamesMcGill = new Employee("James", "McGill", new Address("London", "Grove St.", "12A", null), LocalDate.parse("1984-04-21"));
        Employee alexMitchell = new Employee("Alex", "Mitchell", new Address("Birmingham", "Saint St.", "164", "10"), LocalDate.parse("1984-04-21"));
        Employee thomasReyes = new Employee("Thomas", "Reyes", new Address("Manchester", "Main St.", "19", null), LocalDate.parse("1984-04-21"));

        Department londonDepartment = new Department("London Department", new Address("London", "Silly St.", "477", "137"));
        londonDepartment.addEmployee(jamesMcGill);
        Department birminghamDepartment = new Department("Birmingham Department", new Address("Birmingham", "Lucky St.", "831", "76A"));
        birminghamDepartment.addEmployee(alexMitchell);
        Department manchesterDepartment = new Department("Manchester Department", new Address("Manchester", "Beautiful St.", "23", "54"));
        manchesterDepartment.addEmployee(thomasReyes);
        travelAgency.setDepartments(new Department[]{londonDepartment, birminghamDepartment, manchesterDepartment});

        Client janeTuck = new Client("Jane", "Tuck", "j.tuck@example.com", "000000000");
        Client skylerWhite = new Client("Skyler", "White", "s.white@example.com", "000000000");
        Client charlesBlack = new Client("Charles", "Black", "c.black@example.com", "000000000");

        Trip parisTrip = new Trip("Paris Trip", DESTINATIONS[0],
                Map.of("ACCOMMODATION", 500.0, "TRAVEL", 450.0, "FOOD", 200.0),
                LocalDate.now(), LocalDate.now().plusDays(4));
        Trip niceTrip = new Trip("Nice Trip", DESTINATIONS[1],
                Map.of("ACCOMMODATION", 1200.0, "TRAVEL", 400.0, "FOOD", 550.0),
                LocalDate.now(), LocalDate.now().plusDays(3));
        Trip romeTrip = new Trip("Rome Trip", DESTINATIONS[2],
                Map.of("ACCOMMODATION", 750.0, "TRAVEL", 340.0, "FOOD", 170.0),
                LocalDate.now(), LocalDate.now().plusDays(5));
        Trip milanTrip = new Trip("Milan Trip", DESTINATIONS[3],
                Map.of("ACCOMMODATION", 150.0, "TRAVEL", 290.0, "FOOD", 150.0),
                LocalDate.now(), LocalDate.now().plusDays(7));
        Trip newYorkTrip = new Trip("New York Trip", DESTINATIONS[4],
                Map.of("ACCOMMODATION", 300.0, "TRAVEL", 720.0),
                LocalDate.now(), LocalDate.now().plusDays(6));
        Trip barcelonaTrip = new Trip("Barcelona Trip", DESTINATIONS[5],
                Map.of("ACCOMMODATION", 440.0, "TRAVEL", 600.0, "FOOD", 200.0),
                LocalDate.now(), LocalDate.now().plusDays(3));

        Contract contract1 = new Contract(LocalDate.now(), jamesMcGill, janeTuck, parisTrip);
        jamesMcGill.addContract(contract1);
        Contract contract2 = new Contract(LocalDate.now(), jamesMcGill, charlesBlack, romeTrip);
        jamesMcGill.addContract(contract2);
        Contract contract3 = new Contract(LocalDate.now(), jamesMcGill, skylerWhite, niceTrip);
        jamesMcGill.addContract(contract3);
        Contract contract4 = new Contract(LocalDate.now(), alexMitchell, skylerWhite, barcelonaTrip);
        alexMitchell.addContract(contract4);
        Contract contract5 = new Contract(LocalDate.now(), thomasReyes, charlesBlack, newYorkTrip);
        thomasReyes.addContract(contract5);

        Bill[] bills = new Bill[]{
                new Bill("Rent", 10000.0, false),
                new Bill("Tax", 15000.0, false),
                new Bill("Other", 7000.0, false),
        };
        travelAgency.setBills(bills);
        travelAgency.setBudget(50000.0);
        return travelAgency;
    }
}
