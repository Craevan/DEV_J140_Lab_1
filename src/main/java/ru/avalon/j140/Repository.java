package ru.avalon.j140;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repository {
    public List<User> getUser() {
        String url = ApplicationProperties.getInstance().getProperty("db.url");
        String user = ApplicationProperties.getInstance().getProperty("db.user");
        String password = ApplicationProperties.getInstance().getProperty("db.password");
        List<User> users = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users")) {
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String address = resultSet.getString(3);
                User us = new User(id, name, address);
                users.add(us);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
