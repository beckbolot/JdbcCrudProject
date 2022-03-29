package com.beck.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilDB {
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String username = "postgres";
    private static final String password = "daniel2013";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,username,password);
            System.out.println("Connected to database");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;

    }

}
