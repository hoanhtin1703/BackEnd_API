package com.example.demo.controller;

import com.example.demo.model.Country_Model;
import com.example.demo.repo.CountryReposity;
import com.example.demo.service.Product_ServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("country/")

public class Country_Controller {
    @Autowired
    private CountryReposity countryReposity;
    @Autowired
    Product_ServiceIml country_service;
    // Hiển Thị
    @GetMapping("data")
    List<Country_Model> getAllCountry(){
        return country_service.getAllCountry();

    }
    // Thêm
    @PostMapping("save")
    public ResponseEntity<Country_Model> save(@RequestBody Country_Model country){
        return  new ResponseEntity<Country_Model>(country_service.saveCountry(country), HttpStatus.OK);
    }
// Tìm kiếm
    @GetMapping("search/{keyword}")
    public ResponseEntity<List<Country_Model>> search(@PathVariable("keyword") String keyword){
        return new ResponseEntity<>(countryReposity.findByNameContaining(keyword), HttpStatus.OK);

    }
// Tìm kiếm theo id
    @GetMapping("edit/{id}")
    public ResponseEntity<Country_Model> edit(@PathVariable("id") Long id){
        Optional<Country_Model> item = country_service.findCountryById(id);
        return ResponseEntity.of(item);
    }
    // Chỉnh sửa
    @PutMapping("update")
    public ResponseEntity<Country_Model> updateTutorial( @RequestBody Country_Model model) {
        return new ResponseEntity<Country_Model>( country_service.saveCountry(model), HttpStatus.OK);
    }
    // Xóa
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Country_Model> deleteCountry(@PathVariable("id") long id){
        try {

            country_service.deleteCountry(id);
            return new ResponseEntity<Country_Model>(HttpStatus.OK);
        }
        catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<Country_Model>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
