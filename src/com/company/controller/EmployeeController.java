package com.company.controller;

import com.company.model.Employee;
import com.company.service.employee.EmployeeServiceIMPL;

import java.util.List;

public class EmployeeController {
    EmployeeServiceIMPL employeeServiceIMPL = new EmployeeServiceIMPL();

    public void addEmployee(Employee employee) {
        employeeServiceIMPL.save(employee);
        employeeServiceIMPL.findAll();
    }

    public void deleteEmployee(int id) {
        employeeServiceIMPL.deleteById(id);
    }

    public void showInfoByName() {
        employeeServiceIMPL.showInformation();
    }

    public void updateStatus(int id) {
        employeeServiceIMPL.updateStatus(id);
    }

    public List<Employee> findByName(String name) {
        return employeeServiceIMPL.findByName(name);
    }

    public void editEmployee(int id, String newName, String newGender, String newType) {
        employeeServiceIMPL.updateEmployee(id, newName, newGender, newType);
    }
}
