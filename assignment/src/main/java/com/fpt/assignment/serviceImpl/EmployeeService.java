package com.fpt.assignment.serviceImpl;

import java.util.List;

import com.fpt.assignment.repository.EmployeeDAO;
import com.fpt.assignment.model.Employee;
import com.fpt.assignment.service.EmployeeInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class EmployeeService implements EmployeeInterface{
    @Autowired
    EmployeeDAO dao;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return dao.findAll(pageable);
    }

    @Override
    public Employee findById(String id) {
        return dao.findById(id).get();
    }

    @Override
    public Employee findAccount(String id, String password) {
        Employee employee = dao.findById(id).get();
        if (employee.getPassword().equalsIgnoreCase(password)) {
            return employee;
        }
        return null;
    }

    @Override
    public Long getCount() {
        return dao.count();
    }

    @Override
    public List<Employee> findAll() {
        return dao.findAll();
    }

    @Override
    public Page<Employee> findByIdAndRole(String id, Boolean role, Pageable pageable) {
        return dao.findByIdOrRole(id, role, pageable);
    }
}
