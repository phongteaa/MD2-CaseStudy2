package com.company.service.salary;

import com.company.model.Salary;
import com.company.service.IServiceGeneric;

public interface ISalaryService extends IServiceGeneric<Salary> {
    double calculateSalary1(String employeeType);
}
