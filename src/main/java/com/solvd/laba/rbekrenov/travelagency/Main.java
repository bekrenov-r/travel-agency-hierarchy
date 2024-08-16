package com.solvd.laba.rbekrenov.travelagency;

import com.solvd.laba.rbekrenov.travelagency.model.*;
import com.solvd.laba.rbekrenov.travelagency.model.contract.Contract;
import com.solvd.laba.rbekrenov.travelagency.model.contract.JobContract;
import com.solvd.laba.rbekrenov.travelagency.model.contract.TripContract;
import com.solvd.laba.rbekrenov.travelagency.model.department.AccountingDepartment;
import com.solvd.laba.rbekrenov.travelagency.model.department.Department;
import com.solvd.laba.rbekrenov.travelagency.model.department.HumanResourcesDepartment;
import com.solvd.laba.rbekrenov.travelagency.model.department.SalesDepartment;
import com.solvd.laba.rbekrenov.travelagency.model.location.Address;
import com.solvd.laba.rbekrenov.travelagency.model.location.Country;
import com.solvd.laba.rbekrenov.travelagency.model.person.Client;
import com.solvd.laba.rbekrenov.travelagency.model.person.employee.Accountant;
import com.solvd.laba.rbekrenov.travelagency.model.person.employee.Employee;
import com.solvd.laba.rbekrenov.travelagency.model.person.employee.HRManager;
import com.solvd.laba.rbekrenov.travelagency.model.person.employee.Salesman;
import com.solvd.laba.rbekrenov.travelagency.service.TravelAgencyService;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Destination[] DESTINATIONS = new Destination[]{
            new Destination(Country.FRANCE, "Paris"),
            new Destination(Country.FRANCE, "Nice"),
            new Destination(Country.ITALY, "Rome"),
            new Destination(Country.ITALY, "Milan"),
            new Destination(Country.USA, "New York"),
            new Destination(Country.SPAIN, "Barcelona")
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input travel agency name:");
        String name = sc.nextLine();
        System.out.println("Input budget:");
        double budget = sc.nextInt();
        TravelAgency travelAgency = initTravelAgency(name, budget);

        TravelAgencyService service = new TravelAgencyService(travelAgency);
        if(travelAgency.calculateOverallSalary() > travelAgency.getBudget()) {
            System.out.println("Company is bankrupt!");
            return;
        }
        service.paySalaryToAllEmployees(travelAgency.getAllEmployees());
        service.payAllBills();
        System.out.printf("Average employee age: %s\n", service.calculateAverageEmployeeAge(travelAgency.getAllEmployees()));

        SalesDepartment bestSalesDepartment = travelAgency.getBestPerformingSalesDepartment();
        System.out.printf("Best performing department: %s with %s contracts in total.\n", bestSalesDepartment.getName(), bestSalesDepartment.getTotalTripContractsCount());
        System.out.println("Gross income: £" + travelAgency.calculateGrossIncome());
    }

    private static TravelAgency initTravelAgency(String name, double budget) {
        TravelAgency travelAgency = new TravelAgency(name);

        HumanResourcesDepartment hrDepartment = new HumanResourcesDepartment("HR Department", new Address("London", "Great St.", "734", "23-092"));
        travelAgency.setHumanResourcesDepartment(hrDepartment);
        HRManager hrManager = new HRManager("Alice", "Main", "000000000", LocalDate.parse("1970-03-30"));
        hrManager.setEmploymentDate(LocalDate.parse("2015-04-26"));
        hrManager.setMonthSalary(5000.0);
        hrDepartment.addEmployee(hrManager);

        Salesman jamesMcGill = new Salesman("James", "McGill", "000000000", LocalDate.parse("1980-06-21"));
        Salesman alexMitchell = new Salesman("Alex", "Mitchell", "000000000", LocalDate.parse("1994-01-01"));
        Salesman thomasReyes = new Salesman("Thomas", "Reyes", "000000000", LocalDate.parse("2000-10-13"));

        SalesDepartment londonSalesDepartment = new SalesDepartment("London Sales Department", new Address("London", "Silly St.", "477", "137"));
        SalesDepartment birminghamSalesDepartment = new SalesDepartment("Birmingham Sales Department", new Address("Birmingham", "Lucky St.", "831", "76A"));
        SalesDepartment manchesterSalesDepartment = new SalesDepartment("Manchester Sales Department", new Address("Manchester", "Beautiful St.", "23", "54"));
        travelAgency.setSalesDepartments(new SalesDepartment[]{londonSalesDepartment, birminghamSalesDepartment, manchesterSalesDepartment});
        new JobContract(jamesMcGill, hrManager, londonSalesDepartment, 4500.0).sign();
        new JobContract(alexMitchell, hrManager, birminghamSalesDepartment, 4500.0).sign();
        new JobContract(thomasReyes, hrManager, manchesterSalesDepartment, 4500.0).sign();

        AccountingDepartment accountingDepartment = new AccountingDepartment("Accounting department", new Address("Liverpool", "Main St.", "31", "67", "734-242"));
        travelAgency.setAccountingDepartment(accountingDepartment);
        Employee accountant = new Accountant("Susan", "Public", "000000000", LocalDate.parse("1992-08-22"));
        new JobContract(accountant, hrManager, accountingDepartment, 4000.0).sign();

        Client janeTuck = new Client("Jane", "Tuck", "000000000", LocalDate.parse("1984-04-21"));
        Client skylerWhite = new Client("Skyler", "White", "000000000", LocalDate.parse("1999-07-02"));
        Client charlesBlack = new Client("Charles", "Black", "000000000", LocalDate.parse("1967-12-25"));

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

        new TripContract(jamesMcGill, janeTuck, parisTrip).sign();
        new TripContract(jamesMcGill, charlesBlack, romeTrip).sign();
        new TripContract(jamesMcGill, skylerWhite, niceTrip).sign();
        new TripContract(alexMitchell, skylerWhite, barcelonaTrip).sign();
        new TripContract(thomasReyes, charlesBlack, newYorkTrip).sign();

        Bill[] bills = new Bill[]{
                new Bill("Rent", 10000.0, false),
                new Bill("Tax", 15000.0, false),
                new Bill("Other", 7000.0, false),
        };
        travelAgency.setBills(bills);
        travelAgency.setBudget(budget);
        System.out.printf("Initialized travel agency '%s' with budget £%.2f\n", name, budget);
        return travelAgency;
    }
}
