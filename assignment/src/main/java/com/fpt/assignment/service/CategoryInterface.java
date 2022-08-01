package com.fpt.assignment.service;

import java.util.List;

import com.fpt.assignment.model.Category;

public interface CategoryInterface {
    List<Category> findAll();

    Category findById(Integer id);

    Integer getCount();

    void save(Category category);

    void delete(Integer id);
}
