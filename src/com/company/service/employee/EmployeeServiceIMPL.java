package com.company.service.employee;

import com.company.config.ConfigReadAndWriteFile;
import com.company.model.Employee;
import com.company.model.Salary;
import com.company.model.UserPrincipal;
import com.company.service.salary.SalaryServiceIMPL;
import com.company.service.userprincipal.UserPrincipalServiceIMPL;

import java.util.ArrayList;
import java.util.List;

import static com.company.service.salary.SalaryServiceIMPL.PATH_SALARY;
import static com.company.service.salary.SalaryServiceIMPL.salaryList;

public class EmployeeServiceIMPL implements IEmployeeService {

    List<UserPrincipal> userPrincipalList = UserPrincipalServiceIMPL.userPrincipalList;
    SalaryServiceIMPL salaryServiceIMPL = new SalaryServiceIMPL();

    public static String PATH_EMPLOYEE = ConfigReadAndWriteFile.PATH + "employee.txt";
    public static List<Employee> employeeList = new ConfigReadAndWriteFile<Employee>().readFromFile(PATH_EMPLOYEE);

    @Override
    public List<Employee> findAll() {
        new ConfigReadAndWriteFile<Employee>().writeToFile(PATH_EMPLOYEE, employeeList);
        return employeeList;
    }

    @Override
    public void save(Employee employee) {
        employeeList.add(employee);
    }

    @Override
    public void deleteById(int id) {
        boolean checkId = false;
        for (int i = 0; i < employeeList.size(); i++) {
            if (id == employeeList.get(i).getId()) {
                employeeList.remove(i);
                salaryList.remove(i);
                new ConfigReadAndWriteFile<Salary>().writeToFile(PATH_SALARY, salaryList);
                findAll();
                checkId = true;
                System.out.println("Delete employee successfully");
                break;
            }
        }
        if (!checkId) {
            System.out.println("Employee ID does not exist!");
        }
    }

    @Override
    public void showInformation() {
        System.out.println("\n" + userPrincipalList.get(0).getName());
        System.out.println(userPrincipalList.get(0).getRoleSet());
        System.out.println("Password: " + userPrincipalList.get(0).getPassword());
        System.out.println("Username: " + userPrincipalList.get(0).getUsername());
        System.out.println("ID: " + userPrincipalList.get(0).getId());
        System.out.println("\n");
    }

    @Override
    public void updateStatus(int id) {
        boolean checkStatus = false;
        for (int i = 0; i < employeeList.size(); i++) {
            if (id == employeeList.get(i).getId()) {
                if (employeeList.get(i).getStatus().equalsIgnoreCase("present")) {
                    employeeList.get(i).setStatus("absent");
                } else if (employeeList.get(i).getStatus().equalsIgnoreCase("absent")) {
                    employeeList.get(i).setStatus("present");
                }
                checkStatus = true;
            }
        }
        if (!checkStatus) {
            System.out.println("Employee does not exist!");
        }
    }

    @Override
    public List<Employee> findByName(String name) {
        List<Employee> resultList = new ArrayList<>();
        for (int i = 0; i < employeeList.size(); i++) {
            if (name.equalsIgnoreCase(employeeList.get(i).getName())) {
                resultList.add(employeeList.get(i));
                break;
            }
        }
        return resultList;
    }

    @Override
    public void updateEmployee(int id, String newName, String newGender, String newType) {
        boolean check = false;
        for (int i = 0; i < employeeList.size(); i++) {
            if (id == employeeList.get(i).getId()) {

                employeeList.get(i).setName(newName);
                employeeList.get(i).setGender(newGender);
                employeeList.get(i).setEmployeeType(newType);
                findAll();

                salaryList.get(i).setName(newName);
                salaryList.get(i).setWorkingType(newType);
                salaryList.get(i).setSalaryPerMonth((int) salaryServiceIMPL.calculateSalary1(newType));
                new ConfigReadAndWriteFile<Salary>().writeToFile(PATH_SALARY, salaryList);
                System.out.println("Edit employee successfully!");
                check = true;
            }
        }
        if (!check) {
            System.out.println("ID does not match!");
        }
    }

}

