package com.example.accessing_data_jpa.repository;

import com.example.accessing_data_jpa.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);
    Customer findById(long id);
    List<Customer> findByFirstName(String firstName);

}
