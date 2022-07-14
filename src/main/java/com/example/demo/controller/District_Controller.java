package com.example.demo.controller;

import com.example.demo.model.District_Model;
import com.example.demo.repo.DistrictReposity;
import com.example.demo.service.Product_ServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("district")
public class District_Controller {
    @Autowired
    private DistrictReposity DistrictReposity;
    @Autowired
    Product_ServiceIml district_service;
    // Hiển thị
    @GetMapping("data")
    List<District_Model> getAllDistrict(){
        return district_service.getAllDistrict();

    }
    // thêm
    @PostMapping("save")
    public ResponseEntity<District_Model> save(@RequestBody District_Model District){
        return  new ResponseEntity<District_Model>(district_service.saveDistrict(District), HttpStatus.OK);
    }
// Tìm kiếm
    @GetMapping("search/{keyword}")
    public ResponseEntity<List<District_Model>> search(@PathVariable("keyword") String keyword){
        return new ResponseEntity<>(DistrictReposity.findByNameContaining(keyword), HttpStatus.OK);

    }
// Tìm kiếm theo id
    @GetMapping("edit/{id}")
    public ResponseEntity<District_Model> edit(@PathVariable("id") Long id){
        Optional<District_Model> item = district_service.findDistrictById(id);
        return ResponseEntity.of(item);
    }
    // Chỉnh sửa
    @PutMapping("update")
    public ResponseEntity<District_Model> updateTutorial( @RequestBody District_Model model) {
        return new ResponseEntity<District_Model>( district_service.saveDistrict(model), HttpStatus.OK);
    }
    // Xóa
    @DeleteMapping("delete/{id}")
    public ResponseEntity<District_Model> deleteDistrict(@PathVariable("id") long id){
        try {

            district_service.deleteDistrict(id);
            return new ResponseEntity<District_Model>(HttpStatus.OK);
        }
        catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<District_Model>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
