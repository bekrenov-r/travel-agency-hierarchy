package com.solvd.laba.rbekrenov.travelagency.model.department;

import com.solvd.laba.rbekrenov.travelagency.model.location.Address;
import com.solvd.laba.rbekrenov.travelagency.model.person.employee.Employee;

import java.util.Objects;

public abstract class Department {
    private String name;
    private Address address;

    public Department(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public abstract void addEmployee(Employee employee);

    public abstract Employee[] getEmployees();

    public boolean hasEmployee(Employee employee) {
        for (Employee e : getEmployees()) {
            if (employee.equals(e)) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(o instanceof Department)) return false;
        Department other = (Department) o;

        return Objects.equals(name, other.name) && Objects.equals(address, other.address);
    }

    @Override
    public int hashCode() {
        int hash = Objects.hashCode(name);
        hash = 31 * hash + Objects.hashCode(address);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(getClass().getSimpleName());
        sb.append("{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
