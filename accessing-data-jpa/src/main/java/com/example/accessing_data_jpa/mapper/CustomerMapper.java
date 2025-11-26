package com.example.accessing_data_jpa.mapper;

import com.example.accessing_data_jpa.dto.CustomerDTO;
import com.example.accessing_data_jpa.model.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDTO toDTO(Customer customer);
    List<CustomerDTO> toDTO(List<Customer> customers);
    Customer toEntity(CustomerDTO customerDTO);
}
