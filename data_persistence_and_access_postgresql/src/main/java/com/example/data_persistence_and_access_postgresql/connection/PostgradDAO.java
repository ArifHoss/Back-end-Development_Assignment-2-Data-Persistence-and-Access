package com.example.data_persistence_and_access_postgresql.connection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PostgradDAO {
        @Value("${spring.datasource.url}")
        private String url;
        @Value("${spring.datasource.username}")
        private String username;
        @Value("${spring.datasource.password}")
        private String password;
}
