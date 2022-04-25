package com.company.controller;

import com.company.dto.SignInDto;
import com.company.dto.SignUpDto;
import com.company.model.Role;
import com.company.model.RoleName;
import com.company.model.User;
import com.company.model.UserPrincipal;
import com.company.service.role.RoleServiceIMPL;
import com.company.service.user.UserServiceIMPL;
import com.company.service.userprincipal.UserPrincipalServiceIMPL;


import java.util.HashSet;
import java.util.Set;

public class UserController {
    UserServiceIMPL userServiceIMPL = new UserServiceIMPL();
    RoleServiceIMPL roleServiceIMPL = new RoleServiceIMPL();
    UserPrincipalServiceIMPL userPrincipalServiceIMPL = new UserPrincipalServiceIMPL();

    public void register(SignUpDto signUpDto) {
        int id;
        if (UserServiceIMPL.userList.size() == 0) {
            id = 1;
        } else {
            id = UserServiceIMPL.userList.get(UserServiceIMPL.userList.size() - 1).getId() + 1;
        }

        Set<String> strRole = signUpDto.getStrRole();
        Set<Role> roleSet = new HashSet<>();
        strRole.forEach(role -> {
            switch (role) {
                case "employee":
                    Role employeeRole = roleServiceIMPL.findByName(RoleName.EMPLOYEE);
                    roleSet.add(employeeRole);
                    break;
                case "admin":
                    Role adminRole = roleServiceIMPL.findByName(RoleName.ADMIN);
                    roleSet.add(adminRole);
                    break;
            }
        });

        User user = new User(id, signUpDto.getName(), signUpDto.getUsername(), signUpDto.getPassword(), roleSet);
        userServiceIMPL.save(user);
        userServiceIMPL.findAll();
    }

    public boolean login(SignInDto signInDto) {
        if (userServiceIMPL.checkLogin(signInDto.getUsername(), signInDto.getPassword())) {
            User user = userServiceIMPL.findByUsername(signInDto.getUsername());
            UserPrincipal userPrincipal = new UserPrincipal(user.getId(), user.getName(), user.getUsername(), user.getPassword(), user.getRoleSet());
            userPrincipalServiceIMPL.save(userPrincipal);
            userPrincipalServiceIMPL.findAll();
            return true;
        }
        return false;
    }

    public void deleteAccount(String accName) {
        userServiceIMPL.deleteAccount(accName);
    }


}
