package com.fpt.assignment.service;

import java.util.List;

import com.fpt.assignment.model.Product;

public interface ProductInterface{
    /**
     * Find all products
     * @return
     */
    List<Product> findAll();

    /**
     * Find product with id
     * @param id
     * @return
     */
    Product findById(String id);

    /**
     * Find product with name
     * @param name
     * @return
     */
    Product findByName(String name);

    /**
     * Find list products have distance price from to
     * @param from
     * @param to
     * @return
     */
    List<Product> findPrice(double from, double to);


    /**
     * get numbers product in product table
     * @return
     */
    Long findNumberOrders();


    /**
     * Save an item product
     * @param product
     */
    void save(Product product);


    /**
     * Delete an item product with id
     * @param id
     */
    void delete(String id);
}
