package com.codegym.repository;

import com.codegym.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository{

    @Override
    public List<Customer> findAll() throws SQLException, ClassNotFoundException {
        Connection conn = ConnectionUtils.connect();
        List<Customer> customers = new ArrayList<>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM `customers`");
        while (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String address = rs.getString("address");
            Customer customer = new Customer(id, name, email, address);
            customers.add(customer);
        }
        conn.close();
        return customers;
    }

    @Override
    public boolean save(Customer customer) throws SQLException, ClassNotFoundException {
        Connection conn = ConnectionUtils.connect();
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO `customers`(`name`, `email`, `address`) VALUES(?, ?, ?)");
        preparedStatement.setString(1, customer.getName());
        preparedStatement.setString(2, customer.getEmail());
        preparedStatement.setString(3, customer.getAddress());
        int affectedRows = preparedStatement.executeUpdate();
        conn.close();
        return affectedRows > 0;
    }

    @Override
    public Customer findById(int id) throws SQLException, ClassNotFoundException {
        Connection conn = ConnectionUtils.connect();
        Customer customer = null;
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM `customers` WHERE `id`=?");
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()){
            String name = rs.getString("name");
            String email = rs.getString("email");
            String address = rs.getString("address");
            customer = new Customer(id, name, email, address);
        }
        conn.close();
    return customer;
    }

    @Override
    public boolean update(int id, Customer customer) throws SQLException, ClassNotFoundException {
        Connection conn = ConnectionUtils.connect();
        PreparedStatement preparedStatement = conn.prepareStatement("UPDATE `customers` SET `name`=?, `email`=?, `address`=? WHERE `id`=?");
        preparedStatement.setString(1, customer.getName());
        preparedStatement.setString(2, customer.getEmail());
        preparedStatement.setString(3, customer.getAddress());
        preparedStatement.setInt(4, customer.getId());
        int affectedRows = preparedStatement.executeUpdate();
        conn.close();
        return affectedRows > 0;
    }

    @Override
    public boolean remove(int id) throws SQLException, ClassNotFoundException {
        Connection conn = ConnectionUtils.connect();
        Statement stmt = conn.createStatement();
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM `customers` WHERE `id`=?");
        preparedStatement.setInt(1, id);
        int affectedRows = preparedStatement.executeUpdate();
        conn.close();
        return  affectedRows > 0;
    }
}
