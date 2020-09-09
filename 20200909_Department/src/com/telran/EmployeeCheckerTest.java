package com.telran;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeCheckerTest {

    EmployeeChecker checker = new EmployeeChecker();

    @Test
    public void testEmployeeAmount() {

        Employee customerConsultant = new Employee("Dan", 2000);
        Employee saleManager = new Employee("Sam", 4000);
        Employee marketingConsultant = new Employee("Kate", 3000);
        Employee teamManager = new Employee("Alex", 5000);

        Employee juniorDev = new Employee("Jack", 3000);
        Employee middleDev = new Employee("Kathrin", 4000);
        Employee seniorDev = new Employee("Ann", 6000);
        Employee teamLead = new Employee("Fabian", 7000);

        Employee recruiter1 = new Employee("Andy", 3000);
        Employee recruiter2 = new Employee("Peter", 3000);
        Employee hr = new Employee("Doris", 4000);
        Employee operationsSpecialist = new Employee("Harry", 3500);

        List<Employee> customerServiceTeam = Arrays.asList(customerConsultant, saleManager, marketingConsultant, teamManager);
        List<Employee> devTeam = Arrays.asList(juniorDev, middleDev, seniorDev, teamLead);
        List<Employee> hrTeam = Arrays.asList(recruiter1, recruiter2, hr, operationsSpecialist);

        Department customerService = new Department("CustomerService", "bb123-aa45", customerServiceTeam);
        Department programmers = new Department("IT", "cc123-rr55", devTeam);
        Department humanRecourses = new Department("HR", "dd66-tt44", hrTeam);

        List<Department> departments = Arrays.asList(customerService, programmers, humanRecourses);

        assertEquals(1, checker.countEmployees(departments, 5000, "bb123"));
        assertEquals(2, checker.countEmployees(departments, 6000, "cc123"));
        assertEquals(4, checker.countEmployees(departments, 3000, "dd66"));
    }

}