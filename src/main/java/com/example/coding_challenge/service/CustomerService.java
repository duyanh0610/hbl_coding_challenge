package com.example.coding_challenge.service;

import com.example.coding_challenge.entity.Customer;
import com.example.coding_challenge.entity.Tag;
import com.example.coding_challenge.entity.dto.CustomerDTO;
import com.example.coding_challenge.entity.request.UserRequest;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<CustomerDTO> getAll();

    Optional<Customer> getCustomer(String id) throws Exception;

    CustomerDTO createCustomer(UserRequest request);

    CustomerDTO updateCustomer(String id, UserRequest request);

    void deleteCustomer(String id) throws Exception;

    List<Customer> findByTag(List<Tag> tags);

}
