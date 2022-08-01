package com.fpt.assignment.serviceImpl;

import java.util.List;

import com.fpt.assignment.repository.CategoryDAO;
import com.fpt.assignment.model.Category;
import com.fpt.assignment.service.CategoryInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class CategoryService implements CategoryInterface{
    @Autowired
    CategoryDAO daoCategoryDAO;

    @Override
    public List<Category> findAll() {
        return daoCategoryDAO.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return daoCategoryDAO.findById(id).get();
    }

    @Override
    public Integer getCount() {
        return (int) daoCategoryDAO.count();
    }

    @Override
    public void save(Category category) {
        daoCategoryDAO.save(category);
    }

    @Override
    public void delete(Integer id) {
        daoCategoryDAO.deleteById(id);
    }
}
