package com.practica.crud.spring_mysql.controller;

import com.practica.crud.spring_mysql.entity.Customer;
import com.practica.crud.spring_mysql.servicie.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin( origins = "http://localhost:4200")
//http://localhost:8080/api/customer
@RequestMapping("/api/customer")
public class CustomerController {

    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
    private final CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //localhost:8080/create
//localhost:8080/create
//localhost:8080/create
    @PostMapping("/crear")
    public Customer save(@RequestBody Customer customer) {
        System.out.println("Cliente recibido:");
        System.out.println("ID: " + customer.getId());
        System.out.println("Nombre: " + customer.getFirstName());
        System.out.println("Apellido: " + customer.getLastName());
        System.out.println("Email: " + customer.getEmail());
        // Otra opción es sobreescribir el método toString() en tu clase Customer

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
