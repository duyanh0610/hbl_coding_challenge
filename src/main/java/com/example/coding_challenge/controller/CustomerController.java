package com.example.coding_challenge.controller;

import com.example.coding_challenge.entity.dto.CustomerDTO;
import com.example.coding_challenge.entity.request.CustomerRequest;
import com.example.coding_challenge.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "/api/v1/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAll () {
        return ResponseEntity.ok().body(customerService.getAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomerDTO> getOne(@PathVariable String id) throws Exception {
        return ResponseEntity.status(200).body(customerService.getCustomer(id));
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> create(@RequestBody CustomerRequest request) {
        return ResponseEntity.status(201).body(customerService.createCustomer(request));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CustomerDTO> update(@PathVariable String id, @RequestBody CustomerRequest request) {
        return ResponseEntity.status(200).body(customerService.updateCustomer(id, request));
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable String id) throws Exception {
        customerService.deleteCustomer(id);
    }

//    @GetMapping(value = "/findByTag")
//    public void findByTag(@)
}
