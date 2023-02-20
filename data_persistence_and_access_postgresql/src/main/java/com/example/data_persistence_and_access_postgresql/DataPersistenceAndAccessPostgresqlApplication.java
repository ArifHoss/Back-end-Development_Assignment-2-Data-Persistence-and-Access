package com.example.data_persistence_and_access_postgresql;

import com.example.data_persistence_and_access_postgresql.model.Customer;
import com.example.data_persistence_and_access_postgresql.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class DataPersistenceAndAccessPostgresqlApplication implements CommandLineRunner {
	private static final Scanner scanner = new Scanner(System.in);
	private final CustomerService customerService;

	public DataPersistenceAndAccessPostgresqlApplication(CustomerService customerService) {
		this.customerService = customerService;
	}

	public static void main(String[] args) {
		SpringApplication.run(DataPersistenceAndAccessPostgresqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.print("Enter the Customer ID: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		Customer customer = customerService.findById(id);
		if (customer != null) {
			System.out.println(customer);
		} else {
			System.out.println("Customer not found");
		}
	}
}
