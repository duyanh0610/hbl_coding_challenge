package com.example.coding_challenge.service.impl;

import com.example.coding_challenge.entity.Customer;
import com.example.coding_challenge.entity.Tag;
import com.example.coding_challenge.entity.dto.CustomerDTO;
import com.example.coding_challenge.entity.request.UserRequest;
import com.example.coding_challenge.repository.CustomerRepository;
import com.example.coding_challenge.service.CustomerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CustomerDTO> getAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(customer -> modelMapper.map(customer, CustomerDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Customer> getCustomer(String id) throws Exception {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer;
    }

    @Override
    public CustomerDTO createCustomer(UserRequest request) {
        Customer customer = modelMapper.map(request, Customer.class);
        customerRepository.save(customer);
        return modelMapper.map(customer, CustomerDTO.class);
    }

    @Override
    public CustomerDTO updateCustomer(String id, UserRequest request) {
        return null;
    }

    @Override
    public void deleteCustomer(String id) throws Exception {
        Optional<Customer> customer = customerRepository.findById(id);
        if (!customer.isPresent()) {
            throw new Exception("Customer not found");
        }
        customerRepository.delete(customer.get());
    }

    @Override
    public List<Customer> findByTag(List<Tag> tags) {
        return null;
    }
}
