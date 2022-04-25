package com.company.controller;

import com.company.model.Salary;
import com.company.service.salary.SalaryServiceIMPL;

import java.util.List;

public class SalaryController {
    SalaryServiceIMPL salaryServiceIMPL = new SalaryServiceIMPL();

    public void createSalary(Salary salary) {
        salaryServiceIMPL.save(salary);
        salaryServiceIMPL.findAll();
    }

    public List<Salary> showSalary() {
        return salaryServiceIMPL.findAll();
    }

    public double calculateSalary(String employeeType) {
        return salaryServiceIMPL.calculateSalary1(employeeType);
    }
}
