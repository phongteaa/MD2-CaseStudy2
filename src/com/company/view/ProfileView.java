package com.company.view;

import com.company.model.Role;
import com.company.model.RoleName;
import com.company.model.UserPrincipal;
import com.company.service.userprincipal.UserPrincipalServiceIMPL;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ProfileView {
    Scanner scanner = new Scanner(System.in);
    List<UserPrincipal> userPrincipalList = UserPrincipalServiceIMPL.userPrincipalList;
    UserPrincipalServiceIMPL userPrincipalServiceIMPL = new UserPrincipalServiceIMPL();



    public ProfileView() {
        if (userPrincipalList.size() != 0) {
            Set<Role> roleSet = userPrincipalList.get(0).getRoleSet();
            List<Role> roleList = new ArrayList<>(roleSet);
            boolean checkRole = roleList.get(0).getName().equals(RoleName.ADMIN);
            System.out.println("\nWelcome to profile of " + userPrincipalList.get(0).getName());
            if (!checkRole) {
                new EmployeeView();
            } else {
                new AdminView();
            }

        } else {
            System.out.println("Please login first! ");

        }
    }

    public void logOut() {
        UserPrincipalServiceIMPL.userPrincipalList.clear();
        userPrincipalServiceIMPL.findAll();
    }

}
