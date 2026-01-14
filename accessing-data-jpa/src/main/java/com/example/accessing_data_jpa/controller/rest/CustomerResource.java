package com.example.accessing_data_jpa.controller.rest;

import com.example.accessing_data_jpa.dto.CustomerDTO;
import com.example.accessing_data_jpa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(CustomerResource.CUSTOMERS)
public class CustomerResource {

    public static final String CUSTOMERS = "/customers";

    @Autowired
    private CustomerService service;

    @GetMapping
    public List<CustomerDTO> getCustomers(@RequestParam(name = "lastName", required = false) String lastName) {

        if(lastName == null) return service.getAllCustomers();
        else return service.getCustomersByLastName(lastName);
    }

    @GetMapping("/{id}")
    public CustomerDTO getCustomer(@PathVariable("id") Long id) {
        return service.getCustomer(id);
    }

    @PostMapping
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO) {
        return service.addCustomer(customerDTO);
    }

    @PutMapping("/{id}")
    public CustomerDTO updateCustomer(@PathVariable("id") Long id,
                                                      @RequestBody CustomerDTO customerDTO) {
        CustomerDTO dto = service.updateCustomer(id, customerDTO);
        return dto;
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") Long id) {
        service.deleteCustomer(id);
    }









}
