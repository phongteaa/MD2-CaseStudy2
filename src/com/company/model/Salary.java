package com.company.model;

import java.io.Serializable;

public class Salary implements Serializable {
    public static final int WORKING_HOURS_PARTTIME = 4;
    public static final int WORKING_HOURS_FULLTIME = 8;
    public static final double PAY_RATE = 12;
    public static final int DEFAULT_WORKING_DAYS = 24;

    private int id;
    private String name;
    private String workingType;
    private int workingDays;
    private double salaryPerMonth;

    public Salary(int id, String name, String workingType, int workingDays, double salaryPerMonth) {
        this.id = id;
        this.name = name;
        this.workingType = workingType;
        this.workingDays = workingDays;
        this.salaryPerMonth = salaryPerMonth;
    }

    public Salary() {
    }



    public int getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(int workingDays) {
        this.workingDays = workingDays;
    }

    public double getSalaryPerMonth() {
        return salaryPerMonth;
    }

    public void setSalaryPerMonth(int salaryPerMonth) {
        this.salaryPerMonth = salaryPerMonth;
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

    public String getWorkingType() {
        return workingType;
    }

    public void setWorkingType(String workingType) {
        this.workingType = workingType;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", workingType='" + workingType + '\'' +
                ", workingDays=" + workingDays +
                ", salaryPerMonth=" + salaryPerMonth +
                '}' + "\n";
    }
}
