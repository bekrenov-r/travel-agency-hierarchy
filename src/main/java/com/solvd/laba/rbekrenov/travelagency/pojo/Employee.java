package com.solvd.laba.rbekrenov.travelagency.pojo;

import com.solvd.laba.rbekrenov.travelagency.pojo.location.Address;

import java.time.LocalDate;
import java.util.UUID;

public class Employee {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate birthDate;
    private Address address;
    private double salary;
    private double bonus;
    private String occupation;
    private Contract[] contracts;

    public Employee(String firstName, String lastName, String email, String phoneNumber, LocalDate birthDate, Address address, double salary, double bonus, String occupation, Contract[] contracts) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.address = address;
        this.salary = salary;
        this.bonus = bonus;
        this.occupation = occupation;
        this.contracts = contracts;
    }


    public String fullName() {
        return firstName + " " + lastName;
    }

    public void addContract(Contract contract) {
        Contract[] contractsNew = new Contract[contracts.length + 1];
        for(int i = 0; i < contracts.length; i++){
            contractsNew[i] = contracts[i];
        }
        contractsNew[contractsNew.length - 1] = contract;
        setContracts(contractsNew);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Contract[] getContracts() {
        return contracts;
    }

    public void setContracts(Contract[] contracts) {
        this.contracts = contracts;
    }
}
