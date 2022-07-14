package com.example.demo.controller;

import com.example.demo.model.City_Model;
import com.example.demo.repo.CityReposity;
import com.example.demo.service.Product_ServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("city")
public class City_Controller {
    @Autowired
    private CityReposity CityReposity;
    @Autowired
    Product_ServiceIml city_service;
    // Hiển Thị
    @GetMapping("data")
    List<City_Model> getAllCity(){
        return city_service.getAllCity();

    }
    // Thêm
    @PostMapping("save")
    public ResponseEntity<City_Model> save(@RequestBody City_Model City){
        return  new ResponseEntity<City_Model>(city_service.saveCity(City), HttpStatus.OK);
    }
// Tìm kiếm
    @GetMapping("search/{keyword}")
    public ResponseEntity<List<City_Model>> search(@PathVariable("keyword") String keyword){
        return new ResponseEntity<>(CityReposity.findByNameContaining(keyword), HttpStatus.OK);

    }
// Tìm kiếm theo id
    @GetMapping("edit/{id}")
    public ResponseEntity<City_Model> edit(@PathVariable("id") Long id){
        Optional<City_Model> item = city_service.findCityById(id);
        return ResponseEntity.of(item);
    }
    // Chỉnh sửa
    @PutMapping("update")
    public ResponseEntity<City_Model> updateTutorial(@RequestBody City_Model model) {
        return new ResponseEntity<City_Model>( city_service.saveCity(model), HttpStatus.OK);
    }
    // Xóa
    @DeleteMapping("delete/{id}")
    public ResponseEntity<City_Model> deleteCity(@PathVariable("id") long id){
        try {

            city_service.deleteCity(id);
            return new ResponseEntity<City_Model>(HttpStatus.OK);
        }
        catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<City_Model>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
