package com.example.coding_challenge.service;

import com.example.coding_challenge.entity.Customer;
import com.example.coding_challenge.entity.Tag;
import com.example.coding_challenge.entity.dto.CustomerDTO;
import com.example.coding_challenge.entity.request.CustomerRequest;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAll();

    CustomerDTO getCustomer(String id) throws Exception;

    CustomerDTO createCustomer(CustomerRequest request);

    CustomerDTO updateCustomer(String id, CustomerRequest request) throws Exception;

    void deleteCustomer(String id) throws Exception;

    List<Customer> findByTag(List<Tag> tags);

}
