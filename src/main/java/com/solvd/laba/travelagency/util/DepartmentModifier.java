package com.solvd.laba.travelagency.util;

import com.solvd.laba.travelagency.model.department.Department;

@FunctionalInterface
public interface DepartmentModifier<T extends Department> {
    void modify(T department);
}
