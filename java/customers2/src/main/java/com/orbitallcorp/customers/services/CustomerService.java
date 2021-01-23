package com.orbitallcorp.customers.services;

import com.jayway.jsonpath.spi.json.GsonJsonProvider;
import com.orbitallcorp.customers.domains.Customer;
import com.orbitallcorp.customers.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer save(Customer customer) {
        return customerRepository.save((customer));
    }

    public Object updateUser(Long id, Customer customer) {

        Object response = customerRepository.findById(id)
                .map( cust -> {
            cust.setName(customer.getName());
            cust.setAge(customer.getAge());
            cust.setDescription(customer.getDescription());
            return cust;
                });

        return response;
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

    public Object findById(Long id){
        return customerRepository.findById(id);
    }

    public Object deleteUser(Long id){

        Object available =  customerRepository.findById(id).map(user -> {
            customerRepository.deleteById(id);
            return user;
        });

        return available;
    }
}