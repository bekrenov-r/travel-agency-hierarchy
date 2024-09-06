package com.solvd.laba.travelagency.model.person;

import com.solvd.laba.travelagency.model.location.Address;

import java.util.Objects;

public class ContactData {
    private String email;
    private String phoneNumber;
    private Address address;

    public ContactData(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public ContactData(String email, String phoneNumber, Address address) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactData)) return false;
        ContactData other = (ContactData) o;

        return Objects.equals(address, other.address) && Objects.equals(email, other.email)
                && Objects.equals(phoneNumber, other.phoneNumber);
    }

    @Override
    public int hashCode() {
        int hash = Objects.hashCode(email);
        hash = 31 * hash + Objects.hashCode(phoneNumber);
        hash = 31 * hash + Objects.hashCode(address);
        return hash;
    }
}
