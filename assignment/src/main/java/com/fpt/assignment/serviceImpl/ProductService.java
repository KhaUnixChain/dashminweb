package com.fpt.assignment.serviceImpl;

import java.util.List;

import javax.persistence.EntityManager;

import com.fpt.assignment.repository.ProductDAO;
import com.fpt.assignment.model.Product;
import com.fpt.assignment.service.ProductInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class ProductService implements ProductInterface{
    @Autowired
    ProductDAO dao;
    @Autowired
    EntityManager em;

    
    @Override
    public List<Product> findAll() {
        return dao.findAll();
    }


    @Override
    public Product findById(String id) {
        return dao.findById(id).get();
    }


    @Override
    public Product findByName(String name) {
        return dao.findByName(name);
    }


    @Override
    public List<Product> findPrice(double from, double to) {
        return dao.findByPriceBetween(from, to);
    }


    @Override
    public Long findNumberOrders() {
        return dao.count();
    }


    @Override
    public void save(Product product) {
        dao.save(product);
    }


    @Override
    public void delete(String id) {
        Product product = dao.findById(id).get();
        dao.delete(product);
    }
}
