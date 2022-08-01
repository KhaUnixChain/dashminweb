package com.fpt.assignment.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fpt.assignment.model.Employee;

public interface EmployeeInterface {
    List<Employee> findAll();

    Page<Employee> findAll(Pageable paaPageable);

    Employee findById(String id);

    Employee findAccount(String id, String password);

    Page<Employee> findByIdAndRole(String id, Boolean role, Pageable pageable);

    Long getCount();
}
