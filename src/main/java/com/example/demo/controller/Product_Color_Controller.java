package com.example.demo.controller;

import com.example.demo.model.Product_Color_Model;
import com.example.demo.service.Product_ServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product/color/")
public class Product_Color_Controller {
    @Autowired
    private Product_ServiceIml productService;
    @GetMapping("show")
    public List<Product_Color_Model> getAllProductColor(){
        return productService.getAllProductColor();
    }

    @PostMapping("add")
    public Product_Color_Model addProductColor(@RequestBody Product_Color_Model product_color_model){

        return (Product_Color_Model)  productService.addProductColor(product_color_model);
    }

}