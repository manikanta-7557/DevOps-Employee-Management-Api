package com.example.employee_management_api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.employee_management_api.model.Employee;

@Service
public class EmployeeService {

    // Temporary in-memory list to simulate a database table
    private final List<Employee> employeeList = new ArrayList<>(List.of(
    new Employee(1, "Manikanta", "Engineering", 175000),
    new Employee(2, "Jai Sri Ram", "HR", 155000),
    new Employee(2, "Loki", "HR", 50000)
));


    // 1. CREATE: Add a new employee
    public Employee addEmployee(Employee employee) {
        employeeList.add(employee);
        return employee;
    }

    // 2. READ: Get all employees
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    // 3. READ: Find a specific employee by ID
    public Optional<Employee> getEmployeeById(int id) {
        return employeeList.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst();
    }

    // 4. UPDATE: Modify an existing employee's details
    public Employee updateEmployee(int id, Employee updatedEmployee) {
        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                emp.setName(updatedEmployee.getName());
                emp.setDepartment(updatedEmployee.getDepartment());
                emp.setSalary(updatedEmployee.getSalary());
                return emp;
            }
        }
        return null; 
    }

    // 5. DELETE: Remove an employee from the list
    public boolean deleteEmployee(int id) {
        return employeeList.removeIf(emp -> emp.getId() == id);
    }
}