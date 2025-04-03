package com.practica.crud.spring_mysql.servicie;

import com.practica.crud.spring_mysql.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer save(Customer customer);
    List<Customer> findAll();
    Customer findById(Integer id);
    void deleteById(Integer id);
    Customer update(Customer customer);


}
