package com.example.demo.service;

import com.example.demo.model.Product_Model;
import com.example.demo.repo.ProductReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Product_ServiceIml implements Product_Service {
    @Autowired
    private ProductReposity productReposity;
    @Override
    public List<Product_Model> getAllUser() {
        return (List<Product_Model>) productReposity.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public Product_Model saveUser(Product_Model product) {
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


}
