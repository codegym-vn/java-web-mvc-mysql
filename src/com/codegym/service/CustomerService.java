package com.codegym.service;

import com.codegym.model.Customer;
import java.sql.SQLException;
import java.util.List;

public interface CustomerService {
    List<Customer> findAll() throws SQLException, ClassNotFoundException;

    boolean save(Customer customer) throws SQLException, ClassNotFoundException;

    Customer findById(int id) throws SQLException, ClassNotFoundException;

    boolean update(int id, Customer customer) throws SQLException, ClassNotFoundException;

    boolean remove(int id) throws SQLException, ClassNotFoundException;
}
