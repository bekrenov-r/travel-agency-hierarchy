package com.solvd.laba.rbekrenov.travelagency.model.person;

import com.solvd.laba.rbekrenov.travelagency.model.location.Address;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public abstract class Person {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate birthDate;
    private Address address;

    public Person(String firstName, String lastName, String phoneNumber, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
    }

    public Person(String firstName, String lastName, String email, String phoneNumber, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
    }

    public Person(String firstName, String lastName, String email, String phoneNumber, LocalDate birthDate, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.address = address;
    }

    public String fullName() {
        return firstName + " " + lastName;
    }

    public int getAgeYears(){
        if(birthDate == null) {
            throw new IllegalStateException("Birth date is null");
        }
        return (int) ChronoUnit.YEARS.between(birthDate, LocalDate.now());
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person other = (Person) o;

        return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
                && Objects.equals(email, other.email)
                && Objects.equals(phoneNumber, other.phoneNumber)
                && Objects.equals(address, other.address);
    }

    @Override
    public int hashCode() {
        int hash = Objects.hashCode(firstName);
        hash = 31 * hash + Objects.hashCode(lastName);
        hash = 31 * hash + Objects.hashCode(email);
        hash = 31 * hash + Objects.hashCode(phoneNumber);
        hash = 31 * hash + Objects.hashCode(address);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Person{");
        sb.append("firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
