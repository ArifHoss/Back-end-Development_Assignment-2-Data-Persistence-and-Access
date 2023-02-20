package com.example.data_persistence_and_access_postgresql.connection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class PostgradDAO {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;


    public void test() {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connecting to posters ..."+connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
