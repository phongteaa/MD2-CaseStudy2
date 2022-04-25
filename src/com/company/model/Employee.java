package com.company.model;

import java.io.Serializable;

public class Employee implements Serializable {
    private int id;
    private String name, gender, status, employeeType;

    public Employee(int id, String name, String gender, String status, String employeeType) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.status = status;
        this.employeeType = employeeType;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", status='" + status + '\'' +
                ", employeeType='" + employeeType + '\'' +
                '}' + "\n";
    }
}
