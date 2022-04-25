package com.company.service.employee;

import com.company.model.Employee;
import com.company.service.IServiceGeneric;

import java.util.List;

public interface IEmployeeService extends IServiceGeneric<Employee> {
    void deleteById(int id);

    void showInformation();
    void updateStatus(int id);


    List<Employee> findByName(String name);

    void updateEmployee(int id, String newName, String newGender, String newType);
}
