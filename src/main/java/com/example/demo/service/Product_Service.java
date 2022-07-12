package com.example.demo.service;

import com.example.demo.model.Product_Model;

import java.util.List;
import java.util.Optional;

public interface Product_Service {
    List<Product_Model> getAllUser();

    public Product_Model saveUser(Product_Model product);

    void deleteUser(Long id);

    Optional<Product_Model> findUserById(Long id);
}
