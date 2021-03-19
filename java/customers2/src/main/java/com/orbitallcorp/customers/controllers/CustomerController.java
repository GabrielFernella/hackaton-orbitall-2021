package com.orbitallcorp.customers.controllers;

import com.orbitallcorp.customers.domains.Customer;
import com.orbitallcorp.customers.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping
    public ResponseEntity<List<Customer>> findAll() {
        List<Customer> customers = customerService.findAll();
        return ResponseEntity.ok(customers);
    }


    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> findOne(@PathVariable("id") Long id) {
        try {
            Customer user = (Customer) customerService.findById(id);
            return ResponseEntity.ok((user));

        }catch (Error err) {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity<Customer> save(@RequestBody Customer cust) {
        Customer savedCustomer = customerService.save((cust));

        return new ResponseEntity(savedCustomer, HttpStatus.CREATED);
    }


    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> alter(@RequestBody Customer customer, @PathVariable("id") Long id) {
        try {
            Customer user = (Customer) customerService.updateUser(id,customer);
            return ResponseEntity.ok((user));

        }catch (Error err) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Customer> delete(@PathVariable("id") Long id) {
        try {
            Customer user = (Customer) customerService.deleteUser(id);
            return ResponseEntity.ok((user));

        }catch (Error err) {
            return ResponseEntity.notFound().build();
        }
    }
}