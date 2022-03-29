package com.beck;

import com.beck.model.User;
import com.beck.service.UserService;
import com.beck.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main( String[] args ) {
        UserService userService = new UserServiceImpl();
//        userService.createTable();
//        userService.dropUserTable();
        User user1 = new User(1, "Beck", "Ege", 43);
//        userService.saveUser(user1);
        User daniel = new User(2, "Daniel", "Ege", 8);
//        userService.saveUser(daniel);
        User urunsa = new User(3, "Urunsa", "Baeva", 37);
//        userService.saveUser(urunsa);
        List<User> userList = new ArrayList<>();
        userList = userService.getAllUsers();
        printUsers(userList);
//        userService.removeUserById(3);

    }

    private static List<User> printUsers(List<User> list) {
        for (User user : list)
            System.out.println(user);
        return list;
    }
}
