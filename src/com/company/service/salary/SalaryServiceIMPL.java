package com.company.service.salary;

import com.company.config.ConfigReadAndWriteFile;
import com.company.model.Salary;

import java.util.List;

public class SalaryServiceIMPL implements ISalaryService {
    public static String PATH_SALARY = ConfigReadAndWriteFile.PATH + "salary.txt";
    public static List<Salary> salaryList = new ConfigReadAndWriteFile<Salary>().readFromFile(PATH_SALARY);


    @Override
    public List<Salary> findAll() {
        new ConfigReadAndWriteFile<Salary>().writeToFile(PATH_SALARY, salaryList);
        return salaryList;
    }

    @Override
    public void save(Salary salary) {
        salaryList.add(salary);
    }


    @Override
    public double calculateSalary1(String employeeType) {
        double salary = 0;
        if (employeeType.equals("parttime")) {
            salary = Salary.WORKING_HOURS_PARTTIME * Salary.DEFAULT_WORKING_DAYS * Salary.PAY_RATE;
        }

        if (employeeType.equals("fulltime")) {
            salary = Salary.WORKING_HOURS_FULLTIME * Salary.DEFAULT_WORKING_DAYS * Salary.PAY_RATE;

        }

        return salary;
    }
}
