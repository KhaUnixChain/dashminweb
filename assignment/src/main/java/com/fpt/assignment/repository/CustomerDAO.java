package com.fpt.assignment.repository;

import com.fpt.assignment.model.Customer;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerDAO extends JpaRepository<Customer, Integer>{
    @Query("SELECT o FROM Customer o WHERE o.name LIKE ?1 OR o.phone LIKE ?1 OR o.email LIKE ?1")
    Page<Customer> findCustomers(String keyword, Pageable pageable);

    @Query("SELECT u FROM Customer u WHERE u.verificationCode = ?1")
    public Customer findByVerificationCode(String code);

    /**
     * this is account when customer login
     * @param email
     * @param password
     * @return
     */
    Customer findByEmailAndPassword(String email, String password);
}
