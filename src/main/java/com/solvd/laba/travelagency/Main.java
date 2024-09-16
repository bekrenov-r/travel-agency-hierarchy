package com.solvd.laba.travelagency;

import com.solvd.laba.travelagency.model.TravelAgency;
import com.solvd.laba.travelagency.model.booking.CostOption;
import com.solvd.laba.travelagency.model.booking.PaymentDetails;
import com.solvd.laba.travelagency.model.booking.Trip;
import com.solvd.laba.travelagency.model.contract.JobContract;
import com.solvd.laba.travelagency.model.contract.TripContract;
import com.solvd.laba.travelagency.model.department.AccountingDepartment;
import com.solvd.laba.travelagency.model.department.HumanResourcesDepartment;
import com.solvd.laba.travelagency.model.department.SalesDepartment;
import com.solvd.laba.travelagency.model.finance.Bill;
import com.solvd.laba.travelagency.model.finance.Currency;
import com.solvd.laba.travelagency.model.finance.payment.BankAccount;
import com.solvd.laba.travelagency.model.location.Address;
import com.solvd.laba.travelagency.model.location.Country;
import com.solvd.laba.travelagency.model.location.Destination;
import com.solvd.laba.travelagency.model.person.Client;
import com.solvd.laba.travelagency.model.person.employee.Accountant;
import com.solvd.laba.travelagency.model.person.employee.Employee;
import com.solvd.laba.travelagency.model.person.employee.HRManager;
import com.solvd.laba.travelagency.model.person.employee.Salesman;
import com.solvd.laba.travelagency.service.CurrencyConverter;
import com.solvd.laba.travelagency.service.TransactionStorageManager;
import com.solvd.laba.travelagency.service.TravelAgencyService;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.*;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);
    private static final boolean CLEAR_TRANSACTIONS_ON_EXIT = true;
    private static final List<Destination> DESTINATIONS;

    static {
        DESTINATIONS = Arrays.asList(
                new Destination(Country.FRANCE, "Paris"),
                new Destination(Country.FRANCE, "Nice"),
                new Destination(Country.ITALY, "Rome"),
                new Destination(Country.ITALY, "Milan"),
                new Destination(Country.USA, "New York"),
                new Destination(Country.SPAIN, "Barcelona")
        );
    }

    public static void main(String[] args) {
        printBanner();
        String name = getAgencyName();
        double budget = getAgencyBudget();
        TravelAgency travelAgency = initTravelAgency(name, budget);

        if(!travelAgency.getAccountingDepartment().budgetSuffices(travelAgency.calculateOverallSalary())) {
            log.error("Company is bankrupt!");
            return;
        }
        TravelAgencyService service = new TravelAgencyService();
        travelAgency.getAccountingDepartment().paySalaryToAllEmployees(travelAgency.getAllEmployees());
        travelAgency.getAccountingDepartment().payAllBills(travelAgency.getBills());
        int averageEmployeeAge = service.calculateAverageAge(travelAgency.getAllEmployees());
        log.info("Average employee age: {}", averageEmployeeAge);

        SalesDepartment bestSalesDepartment = travelAgency.getBestPerformingSalesDepartment()
                .orElseThrow(() -> new RuntimeException("There are no sales departments in travel agency"));
        log.info("Best performing department: {} with {} contracts in total.", bestSalesDepartment.getName(), bestSalesDepartment.getTotalTripContractsCount());

        double grossIncomePrimaryCurrency = travelAgency.calculateGrossIncome();
        double grossIncomeDollars = CurrencyConverter.create(TravelAgency.PRIMARY_CURRENCY, Currency.USD).convert(grossIncomePrimaryCurrency);
        log.info("Gross income: " + TravelAgency.PRIMARY_CURRENCY.format(grossIncomePrimaryCurrency));
        log.info("Gross income in USD: " + Currency.USD.format(grossIncomeDollars));

        List<String> transactionsToday = TransactionStorageManager.getTransactionsOnDate(LocalDate.now());
        log.info("Transactions today: {}", transactionsToday);
        describeTravelAgencyClass();
        if(CLEAR_TRANSACTIONS_ON_EXIT) {
            clearTransactionsReflective();
        }
    }

    private static TravelAgency initTravelAgency(String name, double budget) {
        TravelAgency travelAgency = new TravelAgency(name);

        HumanResourcesDepartment hrDepartment = new HumanResourcesDepartment("HR Department", new Address(Country.GREAT_BRITAIN, "London", "Great St.", "734", "23-092"));
        travelAgency.setHumanResourcesDepartment(hrDepartment);
        HRManager hrManager = new HRManager("Alice", "Main", LocalDate.parse("1970-03-30"));
        hrManager.setEmploymentDate(LocalDate.parse("2015-04-26"));
        hrManager.setMonthSalary(5000.0);
        hrManager.setSalaryCredentials(new BankAccount("000000000000000", 0.0));
        hrDepartment.addEmployee(hrManager);

        Salesman jamesMcGill = new Salesman("James", "McGill", LocalDate.parse("1980-06-21"));
        jamesMcGill.setSalaryCredentials(new BankAccount("000000000000000", 0.0));
        Salesman alexMitchell = new Salesman("Alex", "Mitchell", LocalDate.parse("1994-01-01"));
        alexMitchell.setSalaryCredentials(new BankAccount("000000000000000", 0.0));
        Salesman thomasReyes = new Salesman("Thomas", "Reyes", LocalDate.parse("2000-10-13"));
        thomasReyes.setSalaryCredentials(new BankAccount("000000000000000", 0.0));

        SalesDepartment londonSalesDepartment = new SalesDepartment("London Sales Department", new Address(Country.GREAT_BRITAIN, "London", "Silly St.", "477", "137"));
        SalesDepartment birminghamSalesDepartment = new SalesDepartment("Birmingham Sales Department", new Address(Country.GREAT_BRITAIN, "Birmingham", "Lucky St.", "831", "76A"));
        SalesDepartment manchesterSalesDepartment = new SalesDepartment("Manchester Sales Department", new Address(Country.GREAT_BRITAIN, "Manchester", "Beautiful St.", "23", "54"));
        travelAgency.setSalesDepartments(Set.of(londonSalesDepartment, birminghamSalesDepartment, manchesterSalesDepartment));
        new JobContract(jamesMcGill, hrManager, londonSalesDepartment, 4500.0).sign();
        new JobContract(alexMitchell, hrManager, birminghamSalesDepartment, 4500.0).sign();
        new JobContract(thomasReyes, hrManager, manchesterSalesDepartment, 4500.0).sign();

        AccountingDepartment accountingDepartment = new AccountingDepartment("Accounting department", new Address(Country.GREAT_BRITAIN, "Liverpool", "Main St.", "31", "67", "734-242"));
        accountingDepartment.setCompanyBankAccount(new BankAccount("000000000000000000", budget));
        travelAgency.setAccountingDepartment(accountingDepartment);
        Employee accountant = new Accountant("Susan", "Public", LocalDate.parse("1992-08-22"));
        accountant.setSalaryCredentials(new BankAccount("000000000000000", 0.0));
        new JobContract(accountant, hrManager, accountingDepartment, 4000.0).sign();

        Client janeTuck = new Client("Jane", "Tuck", LocalDate.parse("1984-04-21"));
        Client skylerWhite = new Client("Skyler", "White", LocalDate.parse("1999-07-02"));
        Client charlesBlack = new Client("Charles", "Black", LocalDate.parse("1967-12-25"));

        Trip parisTrip = new Trip("Paris Trip", DESTINATIONS.get(0),
                new PaymentDetails(Map.of(CostOption.ACCOMMODATION, 500.0, CostOption.TRANSPORTATION, 450.0, CostOption.FOOD, 200.0), Currency.GBP),
                LocalDate.now(), LocalDate.now().plusDays(4));
        Trip niceTrip = new Trip("Nice Trip", DESTINATIONS.get(1),
                new PaymentDetails(Map.of(CostOption.ACCOMMODATION, 1200.0, CostOption.TRANSPORTATION, 400.0, CostOption.FOOD, 550.0), Currency.GBP),
                LocalDate.now(), LocalDate.now().plusDays(3));
        Trip romeTrip = new Trip("Rome Trip", DESTINATIONS.get(2),
                new PaymentDetails(Map.of(CostOption.ACCOMMODATION, 750.0, CostOption.TRANSPORTATION, 340.0, CostOption.FOOD, 170.0), Currency.GBP),
                LocalDate.now(), LocalDate.now().plusDays(5));
        Trip milanTrip = new Trip("Milan Trip", DESTINATIONS.get(3),
                new PaymentDetails(Map.of(CostOption.ACCOMMODATION, 150.0, CostOption.TRANSPORTATION, 290.0, CostOption.FOOD, 150.0), Currency.GBP),
                LocalDate.now(), LocalDate.now().plusDays(7));
        Trip newYorkTrip = new Trip("New York Trip", DESTINATIONS.get(4),
                new PaymentDetails(Map.of(CostOption.ACCOMMODATION, 300.0, CostOption.TRANSPORTATION, 720.0), Currency.GBP),
                LocalDate.now(), LocalDate.now().plusDays(6));
        Trip barcelonaTrip = new Trip("Barcelona Trip", DESTINATIONS.get(5),
                new PaymentDetails(Map.of(CostOption.ACCOMMODATION, 440.0, CostOption.TRANSPORTATION, 600.0, CostOption.FOOD, 200.0), Currency.GBP),
                LocalDate.now(), LocalDate.now().plusDays(3));

        milanTrip.book(janeTuck);
        new TripContract(jamesMcGill, janeTuck, parisTrip).sign();
        new TripContract(jamesMcGill, charlesBlack, romeTrip).sign();
        new TripContract(jamesMcGill, skylerWhite, niceTrip).sign();
        new TripContract(alexMitchell, skylerWhite, barcelonaTrip).sign();
        new TripContract(thomasReyes, charlesBlack, newYorkTrip).sign();

        List<Bill> bills = Arrays.asList(
                new Bill("Rent", 10000.0, Currency.GBP,  new BankAccount("000000000000000", 0.0)),
                new Bill("Tax", 15000.0, Currency.GBP, new BankAccount("000000000000000", 0.0)),
                new Bill("Other", 7000.0, Currency.GBP, new BankAccount("000000000000000", 0.0))
        );
        travelAgency.setBills(bills);
        log.info("Initialized travel agency '{}' with budget {}", name, TravelAgency.PRIMARY_CURRENCY.format(budget));
        return travelAgency;
    }

    private static String getAgencyName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input travel agency name:");
        String name = sc.nextLine();
        while (StringUtils.isBlank(name)) {
            System.out.println("Input cannot be empty. Try again");
            name = StringUtils.strip(sc.nextLine());
        }
        String firstLetter = String.valueOf(name.charAt(0));
        if(StringUtils.isAllLowerCase(firstLetter)){
            return StringUtils.capitalize(name);
        }
        return name;
    }

    private static double getAgencyBudget() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input budget:");
        while (true) {
            String input = sc.nextLine();
            if (StringUtils.isNumeric(input)) {
                return Double.parseDouble(input);
            } else {
                System.out.println("Input is not a valid number. Try again");
                sc.next();
            }
        }
    }

    private static void printBanner() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/banner.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    private static void describeTravelAgencyClass() {
        log.info("Describing TravelAgency class: ");

        StringBuilder fieldsStr = new StringBuilder("Fields: ");
        Arrays.stream(TravelAgency.class.getDeclaredFields())
                .forEach(f -> fieldsStr.append("\n").append(f.toGenericString()));
        log.info(fieldsStr.toString());

        StringBuilder constructorsStr = new StringBuilder("Constructors: ");
        Arrays.stream(TravelAgency.class.getConstructors())
                .forEach(c -> constructorsStr.append("\n").append(c.toGenericString()));
        log.info(constructorsStr.toString());

        StringBuilder methodsStr = new StringBuilder("Methods: ");
        Arrays.stream(TravelAgency.class.getDeclaredMethods())
                .forEach(m -> methodsStr.append("\n").append(m.toGenericString()));
        log.info(methodsStr.toString());
    }

    private static void clearTransactionsReflective(){
        try {
            Method clearTransactions = TransactionStorageManager.class.getMethod("clearTransactions");
            clearTransactions.invoke(null);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
    }
}
