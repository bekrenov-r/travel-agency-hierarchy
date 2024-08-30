package com.solvd.laba.rbekrenov.travelagency.model.person;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public abstract class Person {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private ContactData contactData;

    public Person(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public Person(String firstName, String lastName, LocalDate birthDate, ContactData contactData) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.contactData = contactData;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public ContactData getContactData() {
        return contactData;
    }

    public void setContactData(ContactData contactData) {
        this.contactData = contactData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person other = (Person) o;

        return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
                && Objects.equals(contactData, other.contactData);
    }

    @Override
    public int hashCode() {
        int hash = Objects.hashCode(firstName);
        hash = 31 * hash + Objects.hashCode(lastName);
        hash = 31 * hash + Objects.hashCode(contactData);
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
