package com.example.coding_challenge.service.impl;

import com.example.coding_challenge.entity.Customer;
import com.example.coding_challenge.entity.Tag;
import com.example.coding_challenge.entity.dto.CustomerDTO;
import com.example.coding_challenge.entity.request.CustomerRequest;
import com.example.coding_challenge.repository.CustomerRepository;
import com.example.coding_challenge.service.CustomerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
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
            .filter(customer -> !customer.isDelete())
            .map(customer -> modelMapper.map(customer, CustomerDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomer(String id) throws Exception {
        Customer customer = customerRepository.findById(id)
            .orElseThrow(() -> new Exception("Customer not found"));
        return modelMapper.map(customer, CustomerDTO.class);
    }

    @Override
    public CustomerDTO createCustomer(CustomerRequest request) {
        Customer customer = modelMapper.map(request, Customer.class);
        customerRepository.save(customer);
        return modelMapper.map(customer, CustomerDTO.class);
    }

    @Override
    public CustomerDTO updateCustomer(String id, CustomerRequest request) throws Exception {
        Customer customer = customerRepository.findById(id)
            .orElseThrow(() -> new Exception("Customer not found"));
        customer.setName(request.getName());
        customer.setTags(request.getTags());

        customerRepository.save(customer);
        return modelMapper.map(customer, CustomerDTO.class);
    }

    @Override
    public void deleteCustomer(String id) throws Exception {
        Customer customer = customerRepository.findById(id)
            .orElseThrow(() -> new Exception("Customer not found"));
        customer.setDelete(true);
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> findByTag(List<Tag> tags) {
        return null;
    }
}
