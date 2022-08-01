package com.fpt.assignment.repository;

import com.fpt.assignment.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category, Integer>{
    //
}
