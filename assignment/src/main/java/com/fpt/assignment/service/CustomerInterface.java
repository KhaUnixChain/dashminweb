package com.fpt.assignment.service;

import java.util.List;

import com.fpt.assignment.model.Customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerInterface {
    void save(Customer customer);

    List<Customer> findAll();

    Page<Customer> findAll(Pageable pageable);

    Customer findById(Integer id);

    Customer findByEmailAndPassword(String email, String pass);

    Page<Customer> findPhoneAndName(String keyword, Pageable pageable);

    Long getCount();
}
