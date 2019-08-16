package com.lzlg.interview.db;

import java.sql.*;

public class DataBaseOp {
    public static void main(String[] args) {
        select();
    }

    private static void select() {
        Connection connection = getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
            while (resultSet.next()) {
                User user = new User();
                user.name = resultSet.getString("name");
                user.age = resultSet.getInt("age");
                user.address = resultSet.getString("address");
                user.wage = resultSet.getInt("wage");
                System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    private static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false",
                    "root", "lzlg520");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    static class User {
        String name;

        int age;

        String address;

        int wage;

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", address='" + address + '\'' +
                    ", wage=" + wage +
                    '}';
        }
    }
}
