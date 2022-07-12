package com.example.demo.service;

import com.example.demo.model.Brand_Model;
import com.example.demo.model.Product_Color_Model;
import com.example.demo.model.Product_Model;
import com.example.demo.repo.BrandReposity;
import com.example.demo.repo.ProductReposity;
import com.example.demo.repo.Product_Color_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Product_ServiceIml implements Product_Service {
    //Product
    @Autowired
    private ProductReposity productReposity;

    @Override
    public List<Product_Model> getAllUser() {
        return (List<Product_Model>) productReposity.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public Product_Model saveProduct(Product_Model product) {
return productReposity.save(product);
    }

    @Override
    public void deleteUser(Long id) {
productReposity.deleteById(id);
    }

    @Override
    public Optional<Product_Model> findUserById(Long id) {
        return productReposity.findById(id);
    }

//    Brand Service
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


    // Product_Color_Service
    //Add new methos
    @Autowired
    private Product_Color_Repo product_repository;
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
