package com.company.view;

import com.company.controller.EmployeeController;
import com.company.controller.SalaryController;
import com.company.controller.UserController;
import com.company.model.Employee;
import com.company.model.Salary;
import com.company.model.UserPrincipal;
import com.company.service.employee.EmployeeServiceIMPL;
import com.company.service.userprincipal.UserPrincipalServiceIMPL;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AdminView {
    //List<Employee> employeeList = EmployeeServiceIMPL.employeeList;
    EmployeeController employeeController = new EmployeeController();
    UserController userController = new UserController();
    SalaryController salaryController = new SalaryController();

    //List<UserPrincipal> userPrincipalList = UserPrincipalServiceIMPL.userPrincipalList;
    UserPrincipalServiceIMPL userPrincipalServiceIMPL = new UserPrincipalServiceIMPL();
    Scanner scanner = new Scanner(System.in);

    public AdminView() {
        System.out.println("\n- - - - - - - - - - - - - - - - - -");
        System.out.println("Enter following numbers to proceed: ");
        System.out.println("1. Add employee");
        System.out.println("2. Delete employee");
        System.out.println("3. Change employee status");
        System.out.println("4. Search employee");
        System.out.println("5. Show list of employee");
        System.out.println("6. Show salary");
        System.out.println("7. Show list user");
        System.out.println("8. Delete user");
        System.out.println("9. Edit employee");
        System.out.println("10. Logout");

        String input = scanner.nextLine();
        switch (input) {
            case "1":
                addEmployee();
                break;
            case "2":
                deleteEmployee();
                break;
            case "3":
                changeEmployeeStatus();
                break;
            case "4":
                searchEmployee();
                break;
            case "5":
                showEmployeeList();
                break;
            case "6":
                showSalary();
                break;
            case "7":
                new ListUserView();
                break;
            case "8":
                deleteAccount();
                break;
            case "9":
                editEmployee();
                break;
            case "10":
                logOut();
                System.out.println("Logout successfully!");
                new Main();
                break;
            default:
                System.err.println("Please choose again!");
                new AdminView();
        }
    }

    public void editEmployee() {
        while (true) {
            System.out.print("\nEnter the employee ID to edit: ");
            int id;

            try {
                id = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.print("Enter again with a number: ");
                id = Integer.parseInt(scanner.nextLine());

            }
            //scanner.nextLine();

            System.out.print("Change new name: ");
            String name = scanner.nextLine();

            System.out.print("Change gender: ");
            String newGender = scanner.nextLine();

            System.out.print("Change working type: ");
            String newType = scanner.nextLine();

            employeeController.editEmployee(id, name, newGender, newType);

            new AdminView();
        }


    }

    public void backMenu() {
        System.out.println("Enter \"menu\" to return to Menu");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("menu")) {
            new AdminView();
        }
    }

    public void logOut() {
        UserPrincipalServiceIMPL.userPrincipalList.clear();
        userPrincipalServiceIMPL.findAll();
    }

    public void addEmployee() {
        System.out.println("\n================================");

        int id;
        if (EmployeeServiceIMPL.employeeList.size() == 0) {
            id = 1;
        } else {
            id = EmployeeServiceIMPL.employeeList.get(EmployeeServiceIMPL.employeeList.size() - 1).getId() + 1;
        }


        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter employee gender (male/female): ");
        String gender = scanner.nextLine();

        System.out.print("Enter employee status (absent/present): ");
        String status = scanner.nextLine();

        System.out.print("Enter employee type (fulltime/parttime): ");
        String type = scanner.nextLine();

        Employee employee = new Employee(id, name, gender, status, type);
        employeeController.addEmployee(employee);

        Salary salary = new Salary(employee.getId(), employee.getName(), employee.getEmployeeType(), Salary.DEFAULT_WORKING_DAYS, salaryController.calculateSalary(employee.getEmployeeType()));
        salaryController.createSalary(salary);

        System.out.println("Add successfully!");

        new AdminView();
    }

    public void deleteEmployee() {
        while (true) {
            System.out.print("\nEnter employee ID to delete: ");
            int id;
            try {
                id = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.print("Enter again with a number: ");
                id = Integer.parseInt(scanner.nextLine());
            }

            employeeController.deleteEmployee(id);
            System.out.println("Enter \"menu\" to return to Menu");
            String backMenu = scanner.nextLine();
            if (backMenu.equalsIgnoreCase("menu")) {
                new AdminView();
            }

        }

    }

    public void changeEmployeeStatus() {
        while (true) {
            System.out.print("\nEnter employee ID to change status (absent/present): ");
            int id;
            try {
                id = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.print("Enter again with a number: ");
                id = Integer.parseInt(scanner.nextLine());
            }
            employeeController.updateStatus(id);
            new AdminView();
        }

    }

    public void searchEmployee() {
        System.out.print("\nSearch employee by name: ");
        String name = scanner.nextLine();
        System.out.println(employeeController.findByName(name));

        new AdminView();
    }

    public void showEmployeeList() {
        System.out.println("\n" + EmployeeServiceIMPL.employeeList);
        new AdminView();
    }

    public void showSalary() {
        System.out.println("\n" + salaryController.showSalary());
        new AdminView();
    }

    public void deleteAccount() {
        System.out.print("\nEnter account name to delete: ");
        String accName = scanner.nextLine();
        userController.deleteAccount(accName);
        new AdminView();
    }

}
