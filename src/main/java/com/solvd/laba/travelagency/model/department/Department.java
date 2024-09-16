package com.solvd.laba.travelagency.model.department;

import com.solvd.laba.travelagency.model.location.Address;
import com.solvd.laba.travelagency.model.person.employee.Employee;
import com.solvd.laba.travelagency.util.DepartmentModifier;

import java.util.Collection;
import java.util.Objects;

public abstract class Department {
    private String name;
    private Address address;

    public Department(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public abstract void addEmployee(Employee employee);

    public abstract Collection<Employee> getEmployees();

    public boolean hasEmployee(Employee employee) {
        return getEmployees().stream()
                .anyMatch(employee::equals);
    }

    public void modifyDepartment(DepartmentModifier<Department> modifier) {
        modifier.modify(this);
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
