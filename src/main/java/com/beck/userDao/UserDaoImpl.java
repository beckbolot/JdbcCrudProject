package com.beck.userDao;

import com.beck.model.User;
import com.beck.util.UtilDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public void createTable() {
        try (Connection conn = UtilDB.getConnection();
             Statement statement = conn.createStatement()) {
            String create_table =
                    "create table if not exists users" +
                            "(id integer ," +
                            "name VARCHAR(30) NOT NULL," +
                            "last_name VARCHAR(30) NOT NULL," +
                            "age int NOT NULL," +
                            "PRIMARY KEY(id))";
            statement.executeUpdate(create_table);
            System.out.println("Table users created");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    public void saveUser(User user) {
        String insert_user = "insert into users(id,name,last_name,age) values (?,?,?,?)";
        try (Connection conn = UtilDB.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(insert_user)) {
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getLastname());
            preparedStatement.setInt(4, user.getAge());
            preparedStatement.executeUpdate();
            System.out.println(user + "inserted successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<User> getAllUsers() {
        String selectAll = "select * from users";
        List<User> users = new ArrayList<>();
        try (Connection conn = UtilDB.getConnection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(selectAll)) {
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setLastname(resultSet.getString("last_name"));
                user.setAge(resultSet.getInt("age"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    @Override
    public void removeUserById(int id) {
        String deleteById = "delete from users where id = ?";
        try (Connection conn = UtilDB.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(deleteById)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Record deleted successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



    @Override
    public void dropUserTable() {
        try (Connection conn = UtilDB.getConnection();
             Statement statement = conn.createStatement()) {
            String drop_table = "drop table users";
            statement.executeUpdate(drop_table);
            System.out.println("Table users deleted from database");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
