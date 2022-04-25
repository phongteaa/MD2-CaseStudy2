package com.company.view;

import com.company.controller.UserController;
import com.company.dto.SignUpDto;
import com.company.service.user.UserServiceIMPL;

import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class RegisterView {
    Scanner scanner = new Scanner(System.in);

    public RegisterView() {
        UserController userController = new UserController();
        UserServiceIMPL userServiceIMPL = new UserServiceIMPL();

        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Please enter username (a -> z, 0 -> 9, at least 6 characters): ");
        String username;
        boolean checkUsername;
        while (true) {
            username = scanner.nextLine();
            checkUsername = Pattern.matches("[a-z0-9_-]{6,}", username);
            if (userServiceIMPL.existedByUsername(username)) {
                System.err.println("Username already exists. Please try again! ");
            } else if (!checkUsername) {
                System.err.println("Username does not match requirement. Pls try again! ");
            } else {
                break;
            }
        }

        System.out.print("Enter your password (a -> z, 0 -> 9, at least 6 characters): ");
        String password;
        boolean checkPassword;
        while (true) {
            password = scanner.nextLine();
            checkPassword = Pattern.matches("[a-z0-9_-]{6,}", password);
            if (!checkPassword) {
                System.err.println("Try another password");
            } else {
                break;
            }
        }

        boolean check;
        System.out.print("Enter role (\"employee\" or \"admin\"): ");
        String role;

/*        role = scanner.nextLine();

        Set<String> strRole = new HashSet<>();
        strRole.add(role);
        SignUpDto signUpDto = new SignUpDto(name, username, password, strRole);
        userController.register(signUpDto);

        new LoginView();*/

        Set<String> strRole = new HashSet<>();
        while (true) {
            role = scanner.nextLine();
            check = Pattern.matches("employee|admin", role.toLowerCase(Locale.ROOT));
            if (!check) {
                System.err.println("Invalid role. Try again: ");
            } else {
                strRole.add(role.toLowerCase());
                break;
            }
        }
        SignUpDto signUpDto = new SignUpDto(name, username, password, strRole);
        userController.register(signUpDto);
        new LoginView();
    }
}
