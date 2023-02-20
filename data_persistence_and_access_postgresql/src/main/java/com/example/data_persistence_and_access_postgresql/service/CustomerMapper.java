package com.example.data_persistence_and_access_postgresql.service;

import com.example.data_persistence_and_access_postgresql.model.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Customer(
                rs.getInt("customer_id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("company"),
                rs.getString("address"),
                rs.getString("city"),
                rs.getString("state"),
                rs.getString("country"),
                rs.getString("postal_code"),
                rs.getString("phone"),
                rs.getString("fax"),
                rs.getString("email")
        );
    }
}
