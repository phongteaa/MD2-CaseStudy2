package com.company.view;

import com.company.model.Role;
import com.company.model.RoleName;
import com.company.model.UserPrincipal;
import com.company.service.userprincipal.UserPrincipalServiceIMPL;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import static javafx.application.Platform.exit;

public class Main {

    public Main() {
//        List<UserPrincipal> userPrincipalList = UserPrincipalServiceIMPL.userPrincipalList;
//        boolean checkLogin = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n ---------- Employee management ----------- ");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Bye");


        String input = scanner.nextLine();

        switch (input) {
            case "1":
                new RegisterView();
                break;
            case "2":
                new LoginView();
                break;
            case "3":
                System.out.println("Thank you!");
                System.exit(0);
            default:
                System.err.println("Please choose again!");
                new Main();
        }

    }

    public static void main(String[] args) {
        new Main();
    }
}
