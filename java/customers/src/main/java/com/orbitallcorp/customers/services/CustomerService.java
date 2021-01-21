package com.orbitallcorp.customers.services;

import com.orbitallcorp.customers.domains.Customer;
import com.orbitallcorp.customers.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer save(Customer customer) {
        return customerRepository.save((customer));
    }

    public List<Customer> findAll() {
        // O código abaixo é o sugerido pela comunidade Spring Boot:
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers :: add);

        // O código abaixo é a moda antiga, risos!
        /*List<Customer> customers = new ArrayList<Customer>();
        for (Customer customer : (List<Customer>) customerRepository.findAll()) {
            customers.add(customer);
        }*/

        // O código abaixo força o Iterable para List
        // return (List<Customer>) repository.findAll();

        return customers;
    }
}