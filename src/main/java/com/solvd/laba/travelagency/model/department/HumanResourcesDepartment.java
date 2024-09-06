package com.solvd.laba.travelagency.model.department;

import com.solvd.laba.travelagency.model.location.Address;
import com.solvd.laba.travelagency.model.person.employee.Employee;
import com.solvd.laba.travelagency.model.person.employee.HRManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class HumanResourcesDepartment extends Department {
    public static final int EMPLOYMENTS_NEEDED_FOR_PERFORMANCE_BONUS = 3;
    private List<HRManager> hrManagers;

    public HumanResourcesDepartment(String name, Address address) {
        super(name, address);
        this.hrManagers = new ArrayList<>();
    }

    @Override
    public void addEmployee(Employee employee) {
        if(!(employee instanceof HRManager)){
            throw new IllegalArgumentException("Employee is not HR manager");
        }
        hrManagers.add((HRManager) employee);
    }

    @Override
    public Collection<Employee> getEmployees() {
        return new ArrayList<>(hrManagers);
    }

    public List<HRManager> getHrManagers() {
        return hrManagers;
    }

    public void setHrManagers(List<HRManager> hrManagers) {
        this.hrManagers = hrManagers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HumanResourcesDepartment)) return false;
        HumanResourcesDepartment other = (HumanResourcesDepartment) o;

        return super.equals(o) && Objects.equals(hrManagers, other.hrManagers);
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 87 * hash + Objects.hashCode(hrManagers);
        return hash;
    }
}
