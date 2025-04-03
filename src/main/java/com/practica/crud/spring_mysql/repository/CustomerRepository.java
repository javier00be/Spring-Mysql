package com.practica.crud.spring_mysql.repository;

import com.practica.crud.spring_mysql.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository <Customer,Integer>{
}
