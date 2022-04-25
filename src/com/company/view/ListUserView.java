package com.company.view;

import com.company.service.user.UserServiceIMPL;

import java.util.Scanner;

public class ListUserView {
    Scanner scanner = new Scanner(System.in);

    public ListUserView() {
        System.out.println("\n" + UserServiceIMPL.userList);
        new AdminView();
    }
}
