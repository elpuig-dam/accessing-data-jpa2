package com.example.accessing_data_jpa.controller.rest;

import com.example.accessing_data_jpa.model.Customer;
import com.example.accessing_data_jpa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(CustomerResource.CUSTOMERS)
public class CustomerResource {

    public static final String CUSTOMERS = "/customers";

    @Autowired
    private CustomerService service;

    @GetMapping
    public List<Customer> getCustomers(@RequestParam(name = "lastName", required = false) String lastName) {

        if(lastName == null) return service.getAllCustomers();
        else return service.getCustomersByLastName(lastName);
    }



}
