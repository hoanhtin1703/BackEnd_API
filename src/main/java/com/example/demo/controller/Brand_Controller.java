package com.example.demo.controller;

import com.example.demo.model.Brand_Model;
import com.example.demo.service.Product_ServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("brand/")
public class Brand_Controller {
//    @Autowired
//    Product_ServiceIml brandReposity;
    @Autowired
    Product_ServiceIml brand_service;
    @GetMapping("get-brand")
    List<Brand_Model> getAllBrand(){
       return brand_service.getAllBrand();

    }
    @PostMapping("save")
    public ResponseEntity<Brand_Model> save(@RequestBody Brand_Model brand){
      return  new ResponseEntity<Brand_Model>(brand_service.saveBrand(brand), HttpStatus.OK);
    }
    ///
}
