package com.example.demo.service;

import com.example.demo.model.Brand_Model;
import com.example.demo.model.Product_Color_Model;
import com.example.demo.model.Product_Model;
import com.example.demo.model.User_Model;
import com.example.demo.repo.BrandReposity;
import com.example.demo.repo.ProductReposity;
import com.example.demo.repo.Product_Color_Reposity;
import com.example.demo.repo.UserReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Product_ServiceIml implements Product_Service {

    // Product Service Imp
    @Autowired
    private ProductReposity productReposity;

    @Override
    public List<Product_Model> getAllProduct() {
        return (List<Product_Model>) productReposity.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public Product_Model saveProduct(Product_Model product) {
return productReposity.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
productReposity.deleteById(id);
    }

    @Override
    public Optional<Product_Model> findProductById(Long id) {
        return productReposity.findById(id);
    }

    // Brand Service Imp

    @Autowired
    private BrandReposity brandReposity;
    @Override
    public List<Brand_Model> getAllBrand() {
        return brandReposity.findAll();
    }

    @Override
    public Brand_Model saveBrand(Brand_Model brand) {
        return brandReposity.save(brand);
    }

    @Override
    public void deleteBrand(Long id) {
        brandReposity.deleteById(id);
    }

    @Override
    public Optional<Brand_Model> findBrandById(Long id) {
        return brandReposity.findById(id);
    }

    // User Service Imp

    @Autowired
    private UserReposity userReposity;

    @Override
    public List<User_Model> getAllUser() {
        return userReposity.findAll();
    }

    @Override
    public User_Model saveUser(User_Model user) {
        return userReposity.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userReposity.deleteById(id);
    }

    @Override
    public Optional<User_Model> findUserById(Long id) {
        return userReposity.findById(id);
    }


    //product color service
    @Autowired
    private Product_Color_Reposity product_repository;
    @Override
    public List<Product_Color_Model> getAllProductColor() {
        return product_repository.findAll();
    }

    @Override
    public Product_Color_Model addProductColor(Product_Color_Model product_color_model) {
        return (Product_Color_Model) product_repository.save(product_color_model);
    }

    @Override
    public void deleteProductColor(Long product_id) {
        product_repository.deleteById(product_id);
    }
}
