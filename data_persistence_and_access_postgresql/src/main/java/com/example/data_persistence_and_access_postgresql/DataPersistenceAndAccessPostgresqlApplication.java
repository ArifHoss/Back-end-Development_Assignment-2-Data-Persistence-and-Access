package com.example.data_persistence_and_access_postgresql;

import com.example.data_persistence_and_access_postgresql.connection.PostgradDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataPersistenceAndAccessPostgresqlApplication {
	public static void main(String[] args) {
		SpringApplication.run(DataPersistenceAndAccessPostgresqlApplication.class, args);
		PostgradDAO postgradDAO = new PostgradDAO();
		postgradDAO.test();
	}
}
