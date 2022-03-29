package com.beck.service;

import com.beck.model.User;

import java.util.List;

public interface UserService {
    void createTable();
    void saveUser(User user);
    List<User> getAllUsers();
    void removeUserById(int id);
    void dropUserTable();
}
