package com.example.demo.service;

import com.example.demo.model.Brand_Model;
import com.example.demo.model.Product_Color_Model;
import com.example.demo.model.Product_Model;

import java.util.List;
import java.util.Optional;

public interface Product_Service {
    //Product_Service Model
    List<Product_Model> getAllUser();

    public Product_Model saveProduct(Product_Model product);

    void deleteUser(Long id);

    Optional<Product_Model> findUserById(Long id);
    // Brand Model Service
    List<Brand_Model> getAllBrand();
    public Brand_Model saveBrand(Brand_Model brand);
    void deleteBrand(Long id);
    Optional<Brand_Model> findBrandById(Long id);
    // Product_Color Service
    //add method
    List<Product_Color_Model> getAllProductColor();

    Product_Color_Model addProductColor(Product_Color_Model product_color_model);

    void deleteProductColor(Long product_id);


}