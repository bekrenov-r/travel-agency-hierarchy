package com.solvd.laba.rbekrenov.travelagency.model.department;

import com.solvd.laba.rbekrenov.travelagency.model.contract.JobContract;
import com.solvd.laba.rbekrenov.travelagency.model.location.Address;
import com.solvd.laba.rbekrenov.travelagency.model.person.employee.Employee;
import com.solvd.laba.rbekrenov.travelagency.model.person.employee.HRManager;
import com.solvd.laba.rbekrenov.travelagency.model.person.employee.Salesman;

import java.util.Arrays;

public class HumanResourcesDepartment extends Department {
    public static final int EMPLOYMENTS_NEEDED_FOR_PERFORMANCE_BONUS = 3;
    private HRManager[] hrManagers;

    public HumanResourcesDepartment(String name, Address address) {
        super(name, address);
        this.hrManagers = new HRManager[]{};
    }

    @Override
    public void addEmployee(Employee employee) {
        if(!(employee instanceof HRManager)){
            throw new IllegalArgumentException("Employee is not HR manager");
        }
        HRManager[] hrManagersNew = new HRManager[hrManagers.length + 1];
        for(int i = 0; i < hrManagers.length; i++){
            hrManagersNew[i] = hrManagers[i];
        }
        hrManagersNew[hrManagersNew.length - 1] = (HRManager) employee;
        setHrManagers(hrManagersNew);
    }

    @Override
    public Employee[] getEmployees() {
        Employee[] result = new Employee[hrManagers.length];
        for(int i = 0; i < hrManagers.length; i++){
            result[i] = hrManagers[i];
        }
        return result;
    }

    public HRManager[] getHrManagers() {
        return hrManagers;
    }

    public void setHrManagers(HRManager[] hrManagers) {
        this.hrManagers = hrManagers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HumanResourcesDepartment)) return false;
        HumanResourcesDepartment other = (HumanResourcesDepartment) o;

        return super.equals(o) && Arrays.equals(hrManagers, other.hrManagers);
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 87 * hash + Arrays.hashCode(hrManagers);
        return hash;
    }
}
