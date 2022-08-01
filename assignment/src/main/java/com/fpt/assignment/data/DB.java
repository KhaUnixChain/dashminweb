package com.fpt.assignment.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpt.assignment.model.CartItem;
import com.fpt.assignment.model.Product;
import com.fpt.assignment.repository.ProductDAO;

@Service
public class DB {
    @Autowired
    ProductDAO dao;

    public Map<String, CartItem> getDBProducts() {
        List<Product> list = dao.findAll();

        Map<String, CartItem> db = new HashMap<>();

        for (Product product : list) {
            db.put( 
                product.getId(), 
                new CartItem(product.getId(), product, 1)
            );
        }

        return db;
    }
}
