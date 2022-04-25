package com.company.view;

import com.company.controller.UserController;
import com.company.dto.SignInDto;
import com.company.dto.SignUpDto;
import com.company.service.user.UserServiceIMPL;

import java.util.Scanner;

public class LoginView {
    Scanner scanner = new Scanner(System.in);
    UserController userController = new UserController();

    public LoginView() {
        System.out.println("Login form");

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        SignInDto signInDto = new SignInDto(username, password);
        if (userController.login(signInDto)) {
            new ProfileView();
        } else {
            System.err.println("Login failed\n");
            new Main();
        }
    }
}
