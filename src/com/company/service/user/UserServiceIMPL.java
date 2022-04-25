package com.company.service.user;

import com.company.config.ConfigReadAndWriteFile;
import com.company.model.User;
import com.company.model.UserPrincipal;
import com.company.service.userprincipal.UserPrincipalServiceIMPL;

import java.util.List;

public class UserServiceIMPL implements IUserService {
    public static String PATH_USER = ConfigReadAndWriteFile.PATH + "user.txt";
    public static List<User> userList = new ConfigReadAndWriteFile<User>().readFromFile(PATH_USER);
    List<UserPrincipal> userPrincipalList = UserPrincipalServiceIMPL.userPrincipalList;

    @Override
    public List<User> findAll() {
        new ConfigReadAndWriteFile<User>().writeToFile(PATH_USER, userList);
        return userList;
    }

    @Override
    public void save(User user) {
        userList.add(user);
    }

    @Override
    public boolean existedByUsername(String username) {
        for (int i = 0; i < userList.size(); i++) {
            if (username.equals(userList.get(i).getUsername()))
                return true;
        }
        return false;
    }

    @Override
    public boolean checkLogin(String username, String password) {
        for (int i = 0; i < userList.size(); i++) {
            if (username.equals(userList.get(i).getUsername()) && password.equals(userList.get(i).getPassword())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public User findByUsername(String username) {
        for (int i = 0; i < userList.size(); i++) {
            if (username.equals(userList.get(i).getUsername())) {
                return userList.get(i);
            }
        }
        return null;
    }

    @Override
    public void deleteAccount(String accName) {
        boolean checkAccExist = false;
        for (int i = 0; i < userList.size(); i++) {
            if (accName.equals(userPrincipalList.get(0).getUsername())) {
                System.out.println("Unable to delete this user!");
                break;
            } else {
                if (accName.equals(userList.get(i).getUsername())) {
                    userList.remove(i);
                    findAll();
                    checkAccExist = true;
                    System.out.println("Delete user account!");
                    break;
                }
            }
        }
        if (!checkAccExist) {
            System.out.println("Account does not exist!");
        }
    }
}
