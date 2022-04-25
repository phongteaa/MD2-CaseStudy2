package com.company.view;

import com.company.controller.EmployeeController;
import com.company.model.Employee;
import com.company.model.UserPrincipal;
import com.company.service.userprincipal.UserPrincipalServiceIMPL;

import java.util.List;
import java.util.Scanner;

public class EmployeeView {
    List<UserPrincipal> userPrincipalList = UserPrincipalServiceIMPL.userPrincipalList;
    UserPrincipalServiceIMPL userPrincipalServiceIMPL = new UserPrincipalServiceIMPL();
    Scanner scanner = new Scanner(System.in);
    EmployeeController employeeController = new EmployeeController();

    public EmployeeView() {

        System.out.println(" * * * * * * * * * * * * * * * * * ");
        System.out.println("\nEnter following numbers to proceed: ");
        System.out.println("1. Show user information");
        System.out.println("2. Logout");

        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                showInformation();
                break;
            case "2":
                logOut();
                System.out.println("Logout successfully!");
                new Main();
                break;
            default:
                System.err.println("Please choose again!");
                new EmployeeView();
        }
    }

    public void logOut() {
        UserPrincipalServiceIMPL.userPrincipalList.clear();
        userPrincipalServiceIMPL.findAll();
    }

    public void showInformation() {
        employeeController.showInfoByName();
        new EmployeeView();
    }
}
