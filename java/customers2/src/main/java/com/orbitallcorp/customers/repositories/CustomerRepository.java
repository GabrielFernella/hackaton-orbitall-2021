package com.orbitallcorp.customers.repositories;

import com.orbitallcorp.customers.domains.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
//Create
//Retrieve
//Update
//Delete