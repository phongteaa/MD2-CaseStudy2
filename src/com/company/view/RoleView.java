package com.company.view;

import com.company.controller.RoleController;

import java.util.Scanner;

public class RoleView {
    Scanner scanner = new Scanner(System.in);

    public void showListRole() {
        RoleController roleController = new RoleController();
        System.out.println();

        System.out.println(roleController.showListRole());
        System.out.println("Enter \"quit\" to return to Main Menu: ");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new Main();
        }
    }
}
