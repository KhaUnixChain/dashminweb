package com.fpt.assignment.repository;

import com.fpt.assignment.model.Employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeDAO extends JpaRepository<Employee, String>{
    @Query("SELECT o FROM Employee o WHERE o.id LIKE ?1 AND o.role=?2")
    Page<Employee> findByIdOrRole(String id, Boolean role, Pageable pageable);
}
