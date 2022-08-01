package com.fpt.assignment.repository;

import com.fpt.assignment.model.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductDAO extends JpaRepository<Product, String>{
    /**
     * this is get list products by name
     * @param name
     * @return
     */
    @Query("SELECT o FROM Product o WHERE o.name LIKE :name")
    Product findByName(String name);

    /**
     * this is search product from and to with price
     * @param from
     * @param to
     * @return
     */
    List<Product> findByPriceBetween(double from, double to);
}
