package com.solvd.laba.rbekrenov.travelagency.model.contract;

import com.solvd.laba.rbekrenov.travelagency.model.department.Department;
import com.solvd.laba.rbekrenov.travelagency.model.person.employee.Employee;
import com.solvd.laba.rbekrenov.travelagency.model.person.employee.HRManager;

import java.time.LocalDate;

public class JobContract extends Contract {
    private Employee employee;
    private HRManager hrManager;
    private Department department;
    private double monthSalary;

    public JobContract(Employee employee, HRManager hrManager, Department department, double monthSalary) {
        this.employee = employee;
        this.hrManager = hrManager;
        this.department = department;
        this.monthSalary = monthSalary;
    }

    @Override
    public void sign() {
        super.sign();
        hrManager.addJobContract(this);
        employee.setEmploymentDate(LocalDate.now());
        employee.setMonthSalary(monthSalary);
        department.addEmployee(employee);
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public HRManager getHrManager() {
        return hrManager;
    }

    public void setHrManager(HRManager hrManager) {
        this.hrManager = hrManager;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof JobContract)) return false;
        JobContract other = (JobContract) o;
        boolean employeeEquals = (employee == null && other.employee == null)
                || employee.equals(other.employee);
        boolean hrManagerEquals = (hrManager == null && other.hrManager == null)
                || hrManager.equals(other.hrManager);
        boolean departmentEquals = (department == null && other.department == null)
                || department.equals(other.department);
        return super.equals(other) && employeeEquals && hrManagerEquals && departmentEquals;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 37 * hash + (employee == null ? 0 : employee.hashCode());
        hash = 37 * hash + (hrManager == null ? 0 : hrManager.hashCode());
        hash = 37 * hash + (department == null ? 0 : department.hashCode());
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("JobContract{");
        sb.append("employee=").append(employee.fullName());
        sb.append(", hrManager=").append(hrManager.fullName());
        sb.append(", department=").append(department.getName());
        sb.append('}');
        return sb.toString();
    }
}
