package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.repository.ConnectionUtils;
import com.codegym.repository.CustomerRepository;
import com.codegym.repository.CustomerRepositoryImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public List<Customer> findAll() throws SQLException, ClassNotFoundException {
        return this.customerRepository.findAll();
    }

    @Override
    public boolean save(Customer customer) throws SQLException, ClassNotFoundException {
        return this.customerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) throws SQLException, ClassNotFoundException {
        return this.customerRepository.findById(id);
    }

    @Override
    public boolean update(int id, Customer customer) throws SQLException, ClassNotFoundException {
        return this.customerRepository.update(id, customer);
    }

    @Override
    public boolean remove(int id) throws SQLException, ClassNotFoundException {
        return this.customerRepository.remove(id);
    }
}
