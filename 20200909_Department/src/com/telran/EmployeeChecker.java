package com.telran;

import java.util.List;

public class EmployeeChecker {

    public int countEmployees(List<Department> departments, int limit, String prefix) {
        return (int) departments.stream()
                .filter(department -> department.getCode()
                        .startsWith(prefix))
                .flatMap(department -> department.getEmployees()
                        .stream()
                        .filter(employee -> employee.getSalary() >= limit))
                .count();
    }
}
