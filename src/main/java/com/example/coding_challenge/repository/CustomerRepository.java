package com.example.coding_challenge.repository;

import com.example.coding_challenge.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    @Query(
        value = "SELECT * FROM customers c INNER JOIN customer_tag ct ",
        nativeQuery = true
    )
    List<Customer> findCustomerByTags();
}
