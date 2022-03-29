package com.beck.service;

import com.beck.model.User;
import com.beck.userDao.UserDao;
import com.beck.userDao.UserDaoImpl;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();


    @Override
    public void createTable() {
        userDao.createTable();

    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);

    }


    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void removeUserById(int id) {
        userDao.removeUserById(id);

    }


    @Override
    public void dropUserTable() {
        userDao.dropUserTable();

    }
}
