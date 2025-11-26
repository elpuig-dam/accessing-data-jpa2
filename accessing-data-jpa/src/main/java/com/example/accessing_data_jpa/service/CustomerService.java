package com.example.accessing_data_jpa.service;

import com.example.accessing_data_jpa.dto.CustomerDTO;
import com.example.accessing_data_jpa.dto.IncidentDTO;
import com.example.accessing_data_jpa.mapper.CustomerMapper;
import com.example.accessing_data_jpa.model.Customer;
import com.example.accessing_data_jpa.model.Incident;
import com.example.accessing_data_jpa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customerMapper.toDTO(customers);
        //return customers.stream().map(this::convertToCustomerDTO).toList();
        //return (List<Customer>)customerRepository.findAll();
    }

    public List<CustomerDTO> getCustomersByLastName(String lastName) {
        return customerMapper.toDTO(customerRepository.findByLastName(lastName));
        //return customerRepository.findByLastName(lastName).stream().map(this::convertToCustomerDTO).toList();
    }

    public CustomerDTO getCustomer(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer with id " + id + " not found"));
        return customerMapper.toDTO(customer);
    }

    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
        Customer c = customerRepository.save(customerMapper.toEntity(customerDTO));
        return customerMapper.toDTO(c);
    }

    // --- Mètodes de conversió ---

    private CustomerDTO convertToCustomerDTO(Customer customer) {

        // 1. Converteix la llista d'Entitats a una llista de DTOs
        List<IncidentDTO> incidenciaDTOs = customer.getIncidencies()
                .stream()
                .map(this::convertToIncidenciaDTO) // Crida el conversor "fill"
                .toList(); // .toList() és més modern que .collect(Collectors.toList())

        // 2. Crea el DTO "pare" usant el constructor del record
        return new CustomerDTO(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                incidenciaDTOs
        );
    }

    private IncidentDTO convertToIncidenciaDTO(Incident incidencia) {
        // Crea el DTO "fill"
        return new IncidentDTO(
                incidencia.getId(),
                incidencia.getTitol(),
                incidencia.getEstat(),
                incidencia.getDataObertura()
        );
    }



}
