package com.practica.crud.spring_mysql.controller;

import com.practica.crud.spring_mysql.entity.Customer;
import com.practica.crud.spring_mysql.servicie.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private final CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //localhost:8080/create
    @PostMapping("/create")
    public Customer save(@RequestBody Customer customer){
        return customerService.save(customer);
    }

    @GetMapping
    public CustomerService getCustomerService() {

        return customerService;
    }

}
