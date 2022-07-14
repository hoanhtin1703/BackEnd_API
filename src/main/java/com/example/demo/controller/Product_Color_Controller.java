package com.example.demo.controller;

import com.example.demo.model.Product_Color_Model;
import com.example.demo.repo.Product_Color_Reposity;
import com.example.demo.service.Product_ServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("product/color/")
public class Product_Color_Controller {
    @Autowired
    private Product_ServiceIml productService;
    @Autowired
    private Product_Color_Reposity productColorReposity;
    @GetMapping("data")
    public List<Product_Color_Model> getAllProductColor(){
        return productService.getAllProductColor();
    }

    @PostMapping("save")
    public Product_Color_Model addProductColor(@RequestBody Product_Color_Model product_color_model){

        return (Product_Color_Model)  productService.addProductColor(product_color_model);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Product_Color_Model> delete(@RequestParam(name = "product_id") Long id, @RequestParam(name = "image_color") String image_color) {
        System.out.println(id+image_color);
        productColorReposity.deleteProductColorModelByproductidAndimagecolor(id,image_color);
        return  new ResponseEntity<>(HttpStatus.OK);

}}