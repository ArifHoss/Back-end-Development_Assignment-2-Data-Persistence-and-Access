package com.example.data_persistence_and_access_postgresql;

import com.example.data_persistence_and_access_postgresql.model.Customer;
import com.example.data_persistence_and_access_postgresql.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
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
        int choice = -1;
        while (choice != 0) {
            System.out.println("Select an option:");
            System.out.println("1. List all customers");
            System.out.println("2. Find customer by ID");
            System.out.println("3. Find customer by name");
            System.out.println("4. List customers with limit and offset");
            System.out.println("5. Create a new customer");
            System.out.println("6. Update an existing customer");
            System.out.println("7. Delete a customer");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    List<Customer> customers = customerService.findAll();
                    customers.forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Enter customer ID: ");
                    int id = scanner.nextInt();
                    Customer customer = customerService.findById(id);
                    System.out.println(customer);
                    break;
                case 3:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    customer = customerService.findByName(name);
                    System.out.println(customer);
                    break;
                case 4:
                    System.out.print("Enter limit: ");
                    int limit = scanner.nextInt();
                    System.out.print("Enter offset: ");
                    int offset = scanner.nextInt();
                    customers = customerService.findAllWithLimit(limit, offset);
                    customers.forEach(System.out::println);
                    break;
                case 5:
                    System.out.print("Enter first name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter last name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter company: ");
                    String company = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter city: ");
                    String city = scanner.nextLine();
                    System.out.print("Enter state: ");
                    String state = scanner.nextLine();
                    System.out.print("Enter country: ");
                    String country = scanner.nextLine();
                    System.out.print("Enter postal code: ");
                    String postalCode = scanner.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter fax: ");
                    String fax = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    Customer newCustomer = new Customer(0, firstName, lastName, company, address, city, state, country, postalCode, phone, fax, email);
                    customerService.save(newCustomer);
                    System.out.println("New customer created with ID " + newCustomer.id());
                    break;
                case 6:
                    System.out.print("Enter customer ID: ");
                    id = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    customer = customerService.findById(id);
                    if (customer == null) {
                        System.out.println("Customer not found");
                    } else {
                        System.out.println("Enter new customer information:");
                        System.out.print("First name [" + customer.first_name() + "]: ");
                        firstName = scanner.nextLine();
                        firstName = firstName.isEmpty() ? customer.first_name() : firstName;

                        System.out.print("Last name [" + customer.last_name() + "]: ");
                        lastName = scanner.nextLine();
                        lastName = lastName.isEmpty() ? customer.last_name() : lastName;

                        System.out.print("Company [" + customer.company() + "]: ");
                        company = scanner.nextLine();
                        company = company.isEmpty() ? customer.company() : company;

                        System.out.print("Address [" + customer.address() + "]: ");
                        address = scanner.nextLine();
                        address = address.isEmpty() ? customer.address() : address;

                        System.out.print("City [" + customer.city() + "]: ");
                        city = scanner.nextLine();
                        city = city.isEmpty() ? customer.city() : city;

                        System.out.print("State [" + customer.stat() + "]: ");
                        state = scanner.nextLine();
                        state = state.isEmpty() ? customer.stat() : state;

                        System.out.print("Country [" + customer.country() + "]: ");
                        country = scanner.nextLine();
                        country = country.isEmpty() ? customer.country() : country;

                        System.out.print("Postal code [" + customer.postal_code() + "]: ");
                        postalCode = scanner.nextLine();
                        postalCode = postalCode.isEmpty() ? customer.postal_code() : postalCode;

                        System.out.print("Phone [" + customer.phone() + "]: ");
                        phone = scanner.nextLine();
                        phone = phone.isEmpty() ? customer.phone() : phone;

                        System.out.print("Fax [" + customer.fax() + "]: ");
                        fax = scanner.nextLine();
                        fax = fax.isEmpty() ? customer.fax() : fax;

                        System.out.print("Email [" + customer.email() + "]: ");
                        email = scanner.nextLine();
                        email = email.isEmpty() ? customer.email() : email;

                        Customer updatedCustomer = new Customer(id, firstName, lastName, company, address, city, state, country, postalCode, phone, fax, email);
                        customerService.update(updatedCustomer);
                        System.out.println("Customer updated successfully");
                    }
                    break;

            }
        }
    }
}
