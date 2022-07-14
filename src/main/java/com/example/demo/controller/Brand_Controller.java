package com.example.demo.controller;

import com.example.demo.model.Brand_Model;
import com.example.demo.repo.BrandReposity;
import com.example.demo.service.Product_ServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("brand/")
public class Brand_Controller {

    @Autowired
    Product_ServiceIml brand_service;
    @Autowired
    BrandReposity brandReposity;
    // Hiển thị
    @GetMapping("data")
    List<Brand_Model> getAllBrand(){
       return brand_service.getAllBrand();

    }
    // Thêm
    @PostMapping("save")
    public ResponseEntity<Brand_Model> save(@RequestBody Brand_Model brand){
      return  new ResponseEntity<Brand_Model>(brand_service.saveBrand(brand), HttpStatus.OK);
    }
    // Tìm kiếm theo id
    @GetMapping("edit/{id}")
    public ResponseEntity<Brand_Model> edit(@PathVariable("id") Long id){
        Optional<Brand_Model> item = brand_service.findBrandById(id);
        return ResponseEntity.of(item);
    }
    // Chỉnh sửa
    @PutMapping("update")
    public ResponseEntity<Brand_Model> updateTutorial( @RequestBody Brand_Model model) {
        return new ResponseEntity<Brand_Model>( brand_service.saveBrand(model), HttpStatus.OK);
    }
    // Xóa
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Brand_Model> deleteProduct(@PathVariable("id") long id){
        try {

            brand_service.deleteBrand(id);
            return new ResponseEntity<Brand_Model>(HttpStatus.OK);
        }
        catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<Brand_Model>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //    Tìm Kiếm
    @GetMapping("search/{keyword}")
    public ResponseEntity<List<Brand_Model>> search(@PathVariable("keyword") String keyword){
        return new ResponseEntity<>(brandReposity.findByNameContaining(keyword), HttpStatus.OK);

    }
}
