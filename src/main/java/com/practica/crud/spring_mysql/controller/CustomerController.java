package com.practica.crud.spring_mysql.controller;

import com.practica.crud.spring_mysql.entity.Customer;
import com.practica.crud.spring_mysql.servicie.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//http://localhost:8080/api/customer
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //localhost:8080/create
    @PostMapping("/crear")
    public Customer save(@RequestBody Customer customer){
        return customerService.save(customer);
    }

    @GetMapping("/obtener")
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @GetMapping("/obtener/{id}")
    public Customer findById(@PathVariable Integer id){
        return customerService.findById(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void delete(@PathVariable Integer id){
        customerService.deleteById(id);
    }

    @PutMapping ("/actualizar/{id}")
    public Customer update(@RequestBody Customer customer){
        Customer customerDB = customerService.findById(customer.getId());
        customerDB.setFirstName(customer.getFirstName());
        customerDB.setLastName(customer.getLastName());
        customerDB.setEmail(customer.getEmail());
        return customerService.update(customerDB);
    }
}
