package com.beck.userDao;

import com.beck.model.User;

import java.util.List;

public interface UserDao {
    void createTable();
    void saveUser(User user);
    List<User> getAllUsers();
    void removeUserById(int id);
    void dropUserTable();

}
