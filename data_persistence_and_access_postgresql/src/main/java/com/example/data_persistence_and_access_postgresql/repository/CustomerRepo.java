package com.example.data_persistence_and_access_postgresql.repository;

import com.example.data_persistence_and_access_postgresql.exception.CustomIllegalStateException;
import com.example.data_persistence_and_access_postgresql.model.Customer;

import java.util.List;

public interface CustomerRepo {
    List<Customer> findAll();

    Customer findById(int id) throws CustomIllegalStateException;

    Customer findByName(String name);

    List<Customer> findAllWithLimit(int limit, int offset);

    void save(Customer customer);

    void update(Customer customer);

    void delete(int id);

}
